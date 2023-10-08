package com.launchPad.web.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson2.JSON;
import com.launchPad.common.config.RuoYiConfig;
import com.launchPad.common.utils.DateUtils;
import com.launchPad.common.utils.file.FileUploadUtils;
import com.launchPad.common.utils.spring.SpringUtils;
import com.launchPad.framework.config.ServerConfig;
import com.launchPad.web.config.AddressConfig;
import com.launchPad.web.domain.TbProjectCreateDetail;
import com.launchPad.web.domain.TbProjectTokenDistribution;
import com.launchPad.web.domain.TbUserOperateDetail;
import com.launchPad.web.dto.CreateProjectDTO;
import com.launchPad.web.dto.QueryLaunchPadDTO;
import com.launchPad.web.dto.QueryMyPublishLaunchPadDTO;
import com.launchPad.web.dto.TokenDistributeDTO;
import com.launchPad.web.enums.EventType;
import com.launchPad.web.enums.ProjectStatusEnum;
import com.launchPad.web.enums.UserStatusEnum;
import com.launchPad.web.mapper.TbProjectCreateDetailMapper;
import com.launchPad.web.mapper.TbProjectTokenDistributionMapper;
import com.launchPad.web.mapper.TbUserOperateDetailMapper;
import com.launchPad.web.task.ResolvingTasks;
import com.launchPad.web.util.HtgWalletApiService;
import com.launchPad.web.util.ProjectUtil;
import com.launchPad.web.vo.LaunchPadListVO;
import com.launchPad.web.vo.LaunchPadProjectDetailVO;
import com.launchPad.web.vo.MyPublishLaunchPadProjectDetailVO;
import network.nerve.heterogeneous.utils.ListUtil;
import network.nerve.heterogeneous.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.launchPad.web.mapper.TbProjectMapper;
import com.launchPad.web.domain.TbProject;
import com.launchPad.web.service.ITbProjectService;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
    private ServerConfig serverConfig;

    @Autowired
    private TbProjectCreateDetailMapper projectCreateDetailMapper;


    @Autowired
    private TbProjectTokenDistributionMapper tbProjectTokenDistributionMapper;

    @Autowired
    private TbUserOperateDetailMapper tbUserOperateDetailMapper;

    @Autowired
    private AddressConfig addressConfig;

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
        List<LaunchPadListVO> list =  new ArrayList<>();
        if(StringUtils.isBlank(queryLaunchPadDTO.getUserAddress())){
            list  =  tbProjectMapper.getLaunchPadList(queryLaunchPadDTO);
        }else{
            list  =  tbProjectMapper.getLaunchPadListByUser(queryLaunchPadDTO);
        }
        return list;
    }

    /**
     * 获取我发布的项目列表
     *
     *@Author leedan
     *@Description
     *@Date 2023/9/18
     *@param queryLaunchPadDTO
     *@return java.util.List<com.launchPad.web.vo.LaunchPadListVO>
     *@throws
     */
    @Override
    public List<LaunchPadListVO> getMyPublishLaunchPadList(QueryMyPublishLaunchPadDTO queryLaunchPadDTO) {
        List<LaunchPadListVO> list =  tbProjectMapper.getMyPublishLaunchPadList(queryLaunchPadDTO);
        return list;
    }

    /**
     * 获取我发布的项目详情
     *
     *@Author leedan
     *@Description
     *@Date 2023/9/18
     *@param id
     *@return com.launchPad.web.vo.MyPublishLaunchPadProjectDetailVO
     *@throws
     */
    @Override
    public MyPublishLaunchPadProjectDetailVO getMyPublishProjectDetail(String id) throws ParseException {
        MyPublishLaunchPadProjectDetailVO myPublishLaunchPadProjectDetailVO = tbProjectMapper.getMyPublishProjectDetail(id);
        myPublishLaunchPadProjectDetailVO.setLockerAddress(addressConfig.getUniswapV2Locker());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = myPublishLaunchPadProjectDetailVO.getAddLiquidityTime();
        Long lastTime = format.parse(updateTime).getTime()/1000;
        myPublishLaunchPadProjectDetailVO.setAddLiquidityTime(lastTime.toString());
        return myPublishLaunchPadProjectDetailVO;
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

    /***
     * 新增项目
     *
     *@Author leedan
     *@Description
     *@Date 2023/9/18
     *@param createProjectDTO
     *@return int
     *@throws
     */
    @Override
    public String addProject(CreateProjectDTO createProjectDTO) throws IOException {
        TbProject tbProject = new TbProject();
        BeanUtils.copyProperties(createProjectDTO,tbProject);
        String filePath = RuoYiConfig.getUploadPath();
        String fileName = FileUploadUtils.upload(filePath, createProjectDTO.getFiles());
        String url = serverConfig.getUrl() + fileName;
//        String lastUrl =url.substring(url.indexOf("/profile/upload"),url.length());
        tbProject.setImgUrl(url);
        tbProjectMapper.insertTbProject(tbProject);
        Long projectId = tbProject.getId();
        if (StringUtils.isNotBlank(createProjectDTO.getDistributeList())) {
            useLog.info("分配比例传参--------" + createProjectDTO.getDistributeList());
            List<TokenDistributeDTO> list = JSON.parseArray(createProjectDTO.getDistributeList(), TokenDistributeDTO.class);
            for (TokenDistributeDTO tokenAllocationDTO : list) {
                if(!network.nerve.heterogeneous.utils.StringUtils.isBlank(tokenAllocationDTO.getName()) && tokenAllocationDTO.getPercent() != null){
                    TbProjectTokenDistribution tbTokenAllocation = new TbProjectTokenDistribution();
                    BeanUtils.copyProperties(tokenAllocationDTO, tbTokenAllocation);
                    tbTokenAllocation.setProjectId(projectId);
                     tbProjectTokenDistributionMapper.insertTbProjectTokenDistribution(tbTokenAllocation);
                }
            }
        }
        return String.valueOf(projectId);
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
                String[] pid = topics.get(1).split("x");
                // 转账金额
                BigInteger lastUUID = new BigInteger(pid[1], 16);
                tbProject.setId(lastUUID.longValue());
                tbProject =  tbProjectMapper.selectTbProjectById(lastUUID.longValue());
                if(null == tbProject || StringUtils.isBlank(tbProject.getProjectName()) || tbProject.getStatus() != null){
                    return;
                }
                tbProjectCreateDetail.setProjectAddress(list.get(0));
                tbProject.setProjectAddress(list.get(0));
                saleTokenAddress = list.get(2);
                String owner = list.get(1);
                tbProject.setProjectOwner(owner);
                tbProject.setSaleToken(list.get(2));
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
                tbProject.setTokenPrice(new BigDecimal(list.get(1)).divide(new BigDecimal(saleTokenDecimals)).toPlainString());
                //单人最大可买
                String lastMaxPerBugy = new BigDecimal(list.get(2)).divide(new BigDecimal(baseTokenDecimals)).toPlainString();
                tbProject.setMaxPerBuy(lastMaxPerBugy);
                //最大售卖
                String lastHardCap = new BigDecimal(list.get(3)).divide(new BigDecimal(baseTokenDecimals)).toPlainString();
                tbProject.setHardCap(lastHardCap);
                //最小售卖
                String lastSoftCap = new BigDecimal(list.get(4)).divide(new BigDecimal(baseTokenDecimals)).toPlainString();
                tbProject.setSoftCap(lastSoftCap);
                //添加百分比
                tbProject.setPercent(list.get(5));
                //添加token比列
                tbProject.setListRate(new BigDecimal(list.get(6)).divide(new BigDecimal(saleTokenDecimals)).toPlainString());
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
        int projectFlag = tbProjectMapper.updateTbProject(tbProject);
        useLog.info("修改项目基本信息"+projectFlag);
    }

    /**
     * 用户领取项目奖励
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/8
     *@param tx
     *@param height
     *@param logs
     *@return void
     *@throws
     */
    @Override
    public void analysisUserWithdrawTokenProject(Transaction tx, BigInteger height, Log logs) throws Exception {
        TbUserOperateDetail tbUserOperateDetail = new TbUserOperateDetail();
        //解析日志
        List<String> list = new ArrayList<>();
        String temp = logs.getData();
        int j = 2;
        for(int i = 0;i<5;i++){
            String addressStr = temp.substring(j,j+64);
            if(i<3){
                String last = "0x"+addressStr.substring(addressStr.length()-40,addressStr.length());
                list.add(last);
            }else{
                String last =  new BigInteger(addressStr,16).toString();
                list.add(last);
            }
            j = j+64;
        }
        //项目地址
        String projectAddress =   list.get(0);
        //用户地址
        String userAddress =   list.get(1);
        //token地址
//        String tokenAddress = list.get(2);
        //数量
        String amount = list.get(3);
        tbUserOperateDetail.setProjectAddress(projectAddress);
        tbUserOperateDetail.setUserAddress(userAddress);
        tbUserOperateDetail.setTxHash(tx.getHash());
        tbUserOperateDetail.setStatus(Long.valueOf(UserStatusEnum.SUCCESS_YES.getCode()));
        tbUserOperateDetail.setBlockHeight(height.toString());
        tbUserOperateDetail.setAmount(amount);
        //插入数据
        int result = tbUserOperateDetailMapper.insertTbUserOperateDetail(tbUserOperateDetail);
        useLog.info("插入用户领取项目方合同数据结果----"+result);
    }

    /**
     * 用户退出项目
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/8
     *@param tx
     *@param height
     *@param logs
     *@return void
     *@throws
     */
    @Override
    public void analysisUserWithdrawBaseTokenProject(Transaction tx, BigInteger height, Log logs) throws Exception {
        TbUserOperateDetail tbUserOperateDetail = new TbUserOperateDetail();
        //解析日志
        List<String> list = new ArrayList<>();
        String temp = logs.getData();
        int j = 2;
        for(int i = 0;i<4;i++){
            String addressStr = temp.substring(j,j+64);
            if(i<3){
                String last = "0x"+addressStr.substring(addressStr.length()-40,addressStr.length());
                list.add(last);
            }else{
                String last =  new BigInteger(addressStr,16).toString();
                list.add(last);
            }
            j = j+64;
        }
        //项目地址
        String projectAddress =   list.get(0);
        //用户地址
        String userAddress =   list.get(1);
        //token地址
//        String tokenAddress = list.get(2);
        //数量
        String amount = list.get(3);
        tbUserOperateDetail.setProjectAddress(projectAddress);
        tbUserOperateDetail.setUserAddress(userAddress);
        tbUserOperateDetail.setTxHash(tx.getHash());
        tbUserOperateDetail.setStatus(Long.valueOf(UserStatusEnum.FAIL_YES.getCode()));
        tbUserOperateDetail.setBlockHeight(height.toString());
        tbUserOperateDetail.setAmount(amount);
        //插入数据
        int result = tbUserOperateDetailMapper.insertTbUserOperateDetail(tbUserOperateDetail);
        useLog.info("插入用户退出项目数据结果----"+result);
    }

    /**
     * 用户mint
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/8
     *@param tx
     *@param height
     *@param logs
     *@return void
     *@throws
     */
    @Override
    public void analysisUserMintProject(Transaction tx, BigInteger height, Log logs) throws Exception {
        TbUserOperateDetail tbUserOperateDetail = new TbUserOperateDetail();
        //解析日志
        List<String> list = new ArrayList<>();
        String temp = logs.getData();
        int j = 2;
        for(int i = 0;i<3;i++){
            String addressStr = temp.substring(j,j+64);
            if(i<2){
                String last = "0x"+addressStr.substring(addressStr.length()-40,addressStr.length());
                list.add(last);
            }else{
                String last =  new BigInteger(addressStr,16).toString();
                list.add(last);
            }
            j = j+64;
        }
        //项目地址
        String projectAddress =   list.get(0);
        //用户地址
        String userAddress =   list.get(1);
        //token地址
        String amount = list.get(2);
        tbUserOperateDetail.setProjectAddress(projectAddress);
        tbUserOperateDetail.setUserAddress(userAddress);
        tbUserOperateDetail.setTxHash(tx.getHash());
        tbUserOperateDetail.setStatus(Long.valueOf(UserStatusEnum.JOIN.getCode()));
        tbUserOperateDetail.setBlockHeight(height.toString());
        tbUserOperateDetail.setAmount(amount);
        //插入数据
        int result = tbUserOperateDetailMapper.insertTbUserOperateDetail(tbUserOperateDetail);
        useLog.info("用户参与项目----"+result);
    }
}
