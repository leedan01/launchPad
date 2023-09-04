package com.launchPad.web.task;

import com.launchPad.web.config.AddressConfig;
import com.launchPad.web.domain.TbBlockHeader;
import com.launchPad.web.enums.EventType;
import com.launchPad.web.service.ITbBlockHeaderService;
import com.launchPad.web.service.ITbProjectService;
import com.launchPad.web.util.HtgWalletApiService;
import net.sf.jsqlparser.util.validation.ValidationException;
import network.nerve.heterogeneous.core.HtgWalletApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author leedan
 * @Description : 解析日志task
 * @Date 2022/9/5  17:12
 * @Version 1.0
 */
@EnableScheduling
@Component
@Configuration
public class ResolvingTasks {

    private static final Logger log = LoggerFactory.getLogger(ResolvingTasks.class);

    @Autowired
    private AddressConfig addressConfig;

    @Autowired
    private ITbBlockHeaderService blockHeaderService;

    @Autowired
    private ITbProjectService projectService;

    HtgWalletApi htgWalletApi = HtgWalletApiService.getHtgWalletApi();


    /**
     * 获取交易信息
     *
     * @param
     * @return void
     * @throws
     * @Author leedan
     * @Description
     * @Date 2022/8/18
     */
//    @Scheduled(initialDelay = 1000*10, fixedRate = 1000 * 15) //开始多少毫秒时候执行第一次  每隔多少毫秒执行一次
    public void resolveLog() throws Exception {
        long height = htgWalletApi.getBlockHeight();
        //与本地最新比较高度，若跟本地高度不一致则进行区块解析
        TbBlockHeader blockHeaderList = blockHeaderService.selectLastBlockHeader();
        if (blockHeaderList != null) {
            long localHeight = blockHeaderList.getHeight();
            long tempHeight = localHeight + 1;
            log.info("区块高度：" + localHeight);
            if (height != localHeight && height != 0l) {
                long size = height - localHeight;
                //获取连上区块
                for (int i = 0; i < size; i++) {
                    TbBlockHeader tempBlock = new TbBlockHeader();
                    EthBlock.Block block = htgWalletApi.getBlockByHeight(tempHeight);
                    if (block == null) {
                        throw new Exception("解析异常");
                    }
                    tempBlock.setHash(block.getHash());
                    tempBlock.setPreHash(block.getParentHash());
                    tempBlock.setHeight(block.getNumber().longValue());
                    log.info("同步区块高度：" + block.getNumber().longValue());
                    tempBlock.setBlockTime(block.getTimestamp());
                    analysisEthBlock(block);
                    TbBlockHeader blockHeader = new TbBlockHeader();
                    List<TbBlockHeader> list = blockHeaderService.selectTbBlockHeaderList(blockHeader);
                    if (list.size() > 2) {
                        Long[] arr = new Long[list.size() - 2];
                        long finalTempHeight = tempHeight;
                        list.forEach(v -> {
                            if (v.getHeight() != finalTempHeight - 1 && v.getHeight() != finalTempHeight) {
                                int m = 0;
                                arr[m] = (v.getHeight());
                                m++;
                            }
                        });
                        blockHeaderService.deleteTbBlockHeaderByHeights(arr);
                    }
                    blockHeaderService.insertTbBlockHeader(tempBlock);
                    tempHeight = tempHeight + 1;
                    log.info("保存区块 {}", tempBlock.getHeight());
                }
            }
        }
    }

    /**
     * 解析区块,循环区块内的交易信息，过滤数据
     *
     * @param block eth区块
     * @return void
     * @throws
     * @Author leedan
     * @Description
     * @Date 2022/8/19
     */
    public void analysisEthBlock(EthBlock.Block block) throws Exception {
        //获取区块的交易信息
        List<EthBlock.TransactionResult> ethTransactionResults = block.getTransactions();
        int size;
        if (ethTransactionResults != null && (size = ethTransactionResults.size()) > 0) {
            for (int i = 0; i < size; i++) {
//                TransactionResult为接口,每次交易为tx
                Transaction tx = (Transaction) ethTransactionResults.get(i).get();
                String to = tx.getTo();
                if (to != null) {
                    //log.info("to地址--------" + to);
                    //ss
                    if (to.equals(addressConfig.getGenerateAddress()) ) {
                        analysisTx(tx, block.getNumber(), block.getTimestamp());
                    }

                }
            }
        }
    }

    /**
     * 解析每次交易，获取交易事件
     *
     * @param tx
     * @param height
     * @param timestamp
     * @return void
     * @throws
     * @Author leedan
     * @Description
     * @Date 2022/8/19
     */
    public void analysisTx(Transaction tx, BigInteger height, BigInteger timestamp) throws Exception {
        //获取交易hash
        String txHash = tx.getHash();
        //获取交易凭证
        TransactionReceipt receipt = htgWalletApi.getTxReceipt(txHash);
        List<Log> logs = receipt.getLogs();
        for (Log topicLog : logs) {
            //是否需要解析收益
            log.info("address地址" + topicLog.getAddress());
            List<String> topics = topicLog.getTopics();
            String topic0 = topics.get(0);
            switch (topic0) {
//              暂停项目
                case EventType.CREATE_PROJECT:
                    projectService.analysisCreateProject(tx,height,logs);
                    break;
                default:
                    break;
            }
        }

    }










}
