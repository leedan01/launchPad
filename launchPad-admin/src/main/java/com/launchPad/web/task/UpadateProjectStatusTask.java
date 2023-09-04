package com.launchPad.web.task;

import com.launchPad.web.domain.TbProject;
import com.launchPad.web.domain.TbProjectStatusDetail;
import com.launchPad.web.domain.contract.ProjectStatusInfo;
import com.launchPad.web.service.ITbProjectService;
import com.launchPad.web.service.ITbProjectStatusDetailService;
import com.launchPad.web.util.HtgWalletApiService;
import com.launchPad.web.util.ProjectUtil;
import network.nerve.heterogeneous.core.HtgWalletApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * @Author leedan
 * @Description :修改项目信息
 * @Date 2023/8/28  14:46
 * @Version 1.0
 */
@EnableScheduling
@Component
@Configuration
public class UpadateProjectStatusTask {

    private static final Logger log = LoggerFactory.getLogger(UpadateProjectStatusTask.class);

    @Autowired
    private ITbProjectService projectService;

    @Autowired
    private ITbProjectStatusDetailService projectStatusDetailService;


//    @Scheduled(initialDelay = 1000*10, fixedRate = 1000 * 10) //开始多少毫秒时候执行第一次  每隔多少毫秒执行一次
    public void updateProject() throws Exception {
        log.info("修改项目状态数据定时任务");
        HtgWalletApi htgWalletApi = HtgWalletApiService.getHtgWalletApi();
        TbProject tbProject = new TbProject();
        List<TbProject> list = projectService.selectTbProjectList(tbProject);
        for(TbProject temp:list){
            Long id  = temp.getId();
            String projectAddress = temp.getProjectAddress();
            String baseToken = temp.getBaseToken();
            String saleToken = temp.getSaleToken();
            int baseDecimals = htgWalletApi.getERC20TokenDecimals(baseToken);
            int saleDecimals = htgWalletApi.getERC20TokenDecimals(saleToken);
            String status = ProjectUtil.getProjectStatus(htgWalletApi,projectAddress);
            TbProject tbProject1 =  projectService.selectTbProjectById(id);
            tbProject1.setStatus(Long.valueOf(status));
            int result = projectService.updateTbProject(tbProject1);
            log.info("修改项目状态结果------"+result);
            TbProjectStatusDetail tbProjectStatusDetail = new TbProjectStatusDetail();
            tbProjectStatusDetail.setProjectId(id);
            List<TbProjectStatusDetail> list1 =  projectStatusDetailService.selectTbProjectStatusDetailList(tbProjectStatusDetail);
            if(list1.size() >0){
                TbProjectStatusDetail sel = list1.get(0);
                ProjectStatusInfo projectStatusInfo = ProjectUtil.getProjectStatusInfo(htgWalletApi,projectAddress);
                sel.setForceFailed(projectStatusInfo.isFORCE_FAILED());
                sel.setWhiteOnly(projectStatusInfo.isWHITELIST_ONLY());
                sel.setLpGenerationComplete(projectStatusInfo.isLP_GENERATION_COMPLETE());
                String collected = new BigDecimal(projectStatusInfo.getTOTAL_BASE_COLLECTED().toString()).divide(new BigDecimal(ProjectUtil.getDecimals(String.valueOf(baseDecimals)))).toPlainString();
                sel.setTotalBaseCollected(collected);
                String sold = new BigDecimal(projectStatusInfo.getTOTAL_TOKENS_SOLD()).divide(new BigDecimal(ProjectUtil.getDecimals(String.valueOf(saleDecimals)))).toPlainString();
                sel.setTotalTokensSold(sold);
                String solWithdraw = new BigDecimal(projectStatusInfo.getTOTAL_BASE_WITHDRAWN()).divide(new BigDecimal(ProjectUtil.getDecimals(String.valueOf(saleDecimals)))).toPlainString();
                sel.setTotalTokensWithdrawn(solWithdraw);
                String baseWithdraw = new BigDecimal(projectStatusInfo.getTOTAL_BASE_WITHDRAWN()).divide(new BigDecimal(ProjectUtil.getDecimals(String.valueOf(baseDecimals)))).toPlainString();
                sel.setTotalBaseWithdrawn(baseWithdraw);
                sel.setRound1Length(projectStatusInfo.getROUND1_LENGTH().toString());
                sel.setNumBuyers(projectStatusInfo.getNUM_BUYERS().toString());
                int result1 = projectStatusDetailService.updateTbProjectStatusDetail(sel);
                log.info("修改项目状态数据----"+result1);
            }else{
                TbProjectStatusDetail sel = new TbProjectStatusDetail();
                sel.setProjectId(id);
                ProjectStatusInfo projectStatusInfo = ProjectUtil.getProjectStatusInfo(htgWalletApi,projectAddress);
                sel.setForceFailed(projectStatusInfo.isFORCE_FAILED());
                sel.setWhiteOnly(projectStatusInfo.isWHITELIST_ONLY());
                sel.setLpGenerationComplete(projectStatusInfo.isLP_GENERATION_COMPLETE());
                BigInteger lastBase = projectStatusInfo.getTOTAL_BASE_COLLECTED().subtract(projectStatusInfo.getTOTAL_BASE_WITHDRAWN());
                String collected = new BigDecimal(lastBase.toString()).divide(new BigDecimal(ProjectUtil.getDecimals(String.valueOf(baseDecimals)))).toPlainString();
                sel.setTotalBaseCollected(collected);
                BigInteger lastSale =  projectStatusInfo.getTOTAL_TOKENS_SOLD().subtract(projectStatusInfo.getTOTAL_TOKENS_WITHDRAWN());
                String sold = new BigDecimal(lastSale).divide(new BigDecimal(ProjectUtil.getDecimals(String.valueOf(baseDecimals)))).toPlainString();
                sel.setTotalTokensSold(sold);
                String solWithdraw = new BigDecimal(projectStatusInfo.getTOTAL_BASE_WITHDRAWN()).divide(new BigDecimal(ProjectUtil.getDecimals(String.valueOf(saleDecimals)))).toPlainString();
                sel.setTotalTokensWithdrawn(solWithdraw);
                String baseWithdraw = new BigDecimal(projectStatusInfo.getTOTAL_BASE_WITHDRAWN()).divide(new BigDecimal(ProjectUtil.getDecimals(String.valueOf(saleDecimals)))).toPlainString();
                sel.setTotalBaseWithdrawn(baseWithdraw);
                sel.setRound1Length(projectStatusInfo.getROUND1_LENGTH().toString());
                sel.setNumBuyers(projectStatusInfo.getNUM_BUYERS().toString());
                int result1 = projectStatusDetailService.insertTbProjectStatusDetail(sel);
                log.info("插入项目状态数据----"+result1);
            }
        }

    }


}
