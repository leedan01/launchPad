package com.launchPad.web.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import com.launchPad.common.utils.DateUtils;
import com.launchPad.web.domain.TbProjectCreateDetail;
import com.launchPad.web.dto.QueryLaunchPadDTO;
import com.launchPad.web.enums.EventType;
import com.launchPad.web.mapper.TbProjectCreateDetailMapper;
import com.launchPad.web.task.ResolvingTasks;
import com.launchPad.web.util.HtgWalletApiService;
import com.launchPad.web.util.ProjectUtil;
import com.launchPad.web.vo.LaunchPadListVO;
import com.launchPad.web.vo.LaunchPadProjectDetailVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.launchPad.web.mapper.TbProjectMapper;
import com.launchPad.web.domain.TbProject;
import com.launchPad.web.service.ITbProjectService;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.Transaction;

/**
 * 项目基本信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbProjectServiceImpl implements ITbProjectService
{
    @Autowired
    private TbProjectMapper tbProjectMapper;

    @Autowired
    private TbProjectCreateDetailMapper projectCreateDetailMapper;

    private static final Logger useLog = LoggerFactory.getLogger(TbProjectServiceImpl.class);

    /**
     * 查询项目基本信息
     *
     * @param id 项目基本信息主键
     * @return 项目基本信息
     */
    @Override
    public TbProject selectTbProjectById(Long id)
    {
        return tbProjectMapper.selectTbProjectById(id);
    }

    /**
     * 查询项目基本信息列表
     *
     * @param tbProject 项目基本信息
     * @return 项目基本信息
     */
    @Override
    public List<TbProject> selectTbProjectList(TbProject tbProject)
    {
        return tbProjectMapper.selectTbProjectList(tbProject);
    }

    /**
     * 新增项目基本信息
     *
     * @param tbProject 项目基本信息
     * @return 结果
     */
    @Override
    public int insertTbProject(TbProject tbProject)
    {
        tbProject.setCreateTime(DateUtils.getNowDate());
        return tbProjectMapper.insertTbProject(tbProject);
    }

    /**
     * 修改项目基本信息
     *
     * @param tbProject 项目基本信息
     * @return 结果
     */
    @Override
    public int updateTbProject(TbProject tbProject)
    {
        tbProject.setUpdateTime(DateUtils.getNowDate());
        return tbProjectMapper.updateTbProject(tbProject);
    }

    /**
     * 批量删除项目基本信息
     *
     * @param ids 需要删除的项目基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectByIds(Long[] ids)
    {
        return tbProjectMapper.deleteTbProjectByIds(ids);
    }

    /**
     * 删除项目基本信息信息
     *
     * @param id 项目基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectById(Long id)
    {
        return tbProjectMapper.deleteTbProjectById(id);
    }


    /**
     *  获取项目列表
     *
     *@Author leedan
     *@Description
     *@Date 2023/8/24
     *@param queryLaunchPadDTO
     *@return java.util.List<com.launchPad.web.vo.LaunchPadListVO>
     *@throws
     */
    @Override
    public List<LaunchPadListVO> getLaunchPadList(QueryLaunchPadDTO queryLaunchPadDTO) {
       List<LaunchPadListVO> list =  tbProjectMapper.getLaunchPadList(queryLaunchPadDTO);
        return list;
    }

    /**
     * 获取项目详情
     *
     *@Author leedan
     *@Description
     *@Date 2023/8/25
     *@param id
     *@return com.launchPad.web.vo.LaunchPadProjectDetailVO
     *@throws
     */
    @Override
    public LaunchPadProjectDetailVO getLaunchPadDetail(String id) {

        return tbProjectMapper.getLaunchDetailById(id);
    }

    /**
     * 解析新增项目
     *
     *@Author leedan
     *@Description
     *@Date 2023/8/25
     *@param tx
     *@param height
     *@param logs
     *@return void
     *@throws
     */
    @Override
    public void analysisCreateProject(Transaction tx, BigInteger height, List<Log> logs) throws Exception {
        TbProjectCreateDetail tbProjectCreateDetail = new TbProjectCreateDetail();
        String baseTokenAddress = "";
        String baseTokenDecimals = "";
        String tokenBaseSymbol = "";
        String saleTokenAddress = "";
        String saleTokenSymbol ="";
        String saleTokenDecimals = "";
        TbProject tbProject = new TbProject();
        String txHash =  tx.getHash();
        tbProjectCreateDetail.setTxHash(txHash);
        tbProjectCreateDetail.setBlockHeight(height.longValue());
        for (Log tempLog:logs) {
            List<String> topics = tempLog.getTopics();
            String topic0 = topics.get(0);
            if(topic0.equals(EventType.CREATE_PROJECT)){
                String temp = tempLog.getData();
                int j = 2;
                List<String> list = new ArrayList<>();
                for(int i = 0;i<5;i++){
                    String addressStr = temp.substring(j,j+64);
                    String last = "0x"+addressStr.substring(addressStr.length()-40,addressStr.length());
                    list.add(last);
                    j = j+64;
                }
                tbProjectCreateDetail.setProjectAddress(list.get(0));
                tbProject.setProjectAddress(list.get(0));
                saleTokenAddress = list.get(2);
                tbProject.setSaleToken(list.get(2));
                int decimal = HtgWalletApiService.getHtgWalletApi().getERC20TokenDecimals(saleTokenAddress);
                saleTokenDecimals = ProjectUtil.getDecimals(String.valueOf(decimal));
                saleTokenSymbol = HtgWalletApiService.getHtgWalletApi().getERC20TokenSymbol(saleTokenAddress);
                tbProject.setSaleTokenSymbol(saleTokenSymbol);
                baseTokenAddress  = list.get(3);
                tbProject.setBaseToken(list.get(3));
                int decimal1 = HtgWalletApiService.getHtgWalletApi().getERC20TokenDecimals(baseTokenAddress);
                baseTokenDecimals = ProjectUtil.getDecimals(String.valueOf(decimal1));
                tokenBaseSymbol = HtgWalletApiService.getHtgWalletApi().getERC20TokenSymbol(baseTokenAddress);
                tbProject.setBaseTokenSymbol(tokenBaseSymbol);
            }
            if(topic0.equals(EventType.PROJECT_PARAM)){
                String temp = tempLog.getData();
                int j = 2;
                List<String> list = new ArrayList<>();
                for(int i = 0;i<10;i++){
                    String addressStr = temp.substring(j,j+64);
                    String last =  new BigInteger(addressStr,16).toString();
                    list.add(last);
                    j = j+64;
                }
                //转入数量
                String lastAmount = new BigDecimal(list.get(0)).divide(new BigDecimal(saleTokenDecimals)).toPlainString();
                tbProject.setAmount(lastAmount);
                //token价格
                tbProject.setTokenPrice(new BigDecimal(list.get(1)).divide(new BigDecimal(baseTokenDecimals)).toPlainString());
                //单人最大可买
                String lastMaxPerBugy = new BigDecimal(list.get(2)).divide(new BigDecimal(baseTokenDecimals)).toPlainString();
                tbProject.setMaxPerBuy(lastMaxPerBugy);
                //最大售卖
                String lastHardCap = new BigDecimal(list.get(3)).divide(new BigDecimal(saleTokenDecimals)).toPlainString();
                tbProject.setHardCap(lastHardCap);
                //最小售卖
                String lastSoftCap = new BigDecimal(list.get(4)).divide(new BigDecimal(saleTokenDecimals)).toPlainString();
                tbProject.setSoftCap(lastSoftCap);
                //添加百分比
                tbProject.setPercent(list.get(5));
                //添加token比列
                tbProject.setListRate(new BigDecimal(list.get(6)).divide(new BigDecimal(baseTokenDecimals)).toPlainString());
                //开始区块
                tbProject.setStartBlock(list.get(7));
                //结束区块
                tbProject.setEndBlock(list.get(8));
                //锁定时间
                tbProject.setLockPeriod(list.get(9));
            }
        }
        int detailFlag =  projectCreateDetailMapper.insertTbProjectCreateDetail(tbProjectCreateDetail);
        useLog.info("插入项目创建详情结果"+detailFlag);
        int projectFlag = tbProjectMapper.insertTbProject(tbProject);
        useLog.info("插入项目基本信息"+projectFlag);
    }
}
