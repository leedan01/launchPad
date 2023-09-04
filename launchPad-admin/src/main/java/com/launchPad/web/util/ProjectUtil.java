package com.launchPad.web.util;

import com.launchPad.web.domain.contract.ProjectStatusInfo;
import network.nerve.heterogeneous.core.HtgWalletApi;
import network.nerve.heterogeneous.utils.ListUtil;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;

import java.util.List;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/8/28  10:08
 * @Version 1.0
 */
public class ProjectUtil {


    /**
     *  获取带0精度
     *
     *@Author leedan
     *@Description
     *@Date 2023/8/28
     *@param decimals
     *@return java.lang.String
     *@throws
     */
    public static String getDecimals(String decimals){
        Integer decimal = Integer.valueOf(decimals);
        String last = "10";
        for(int i = 1;i<decimal;i++){
            last = last+"0";
        }
        return last;
    }

    /**
     * 获取项目具体信息
     *
     *@Author leedan
     *@Description
     *@Date 2023/8/28
     *@param htgWalletApi
     *@param projectAddress
     *@return com.launchPad.web.domain.contract.ProjectStatusInfo
     *@throws
     */
    public  static ProjectStatusInfo getProjectStatusInfo(HtgWalletApi htgWalletApi,String projectAddress ) throws Exception {

        List<Type> infoResult = htgWalletApi.callViewFunction(projectAddress, new Function("STATUS",
                ListUtil.of(null),
                ListUtil.of(new Object[]{new TypeReference<ProjectStatusInfo>() {}})
        ));
        ProjectStatusInfo poolInfo = (ProjectStatusInfo) infoResult.get(0);
        poolInfo.parse();
        return poolInfo;
    }

    /**
     * 获取项目状态
     *
     *@Author leedan
     *@Description
     *@Date 2023/8/28
     *@param htgWalletApi
     *@param projectAddress
     *@return java.lang.String
     *@throws
     */
    public  static String getProjectStatus(HtgWalletApi htgWalletApi,String projectAddress ) throws Exception {
        List<Type> infoResult = htgWalletApi.callViewFunction(projectAddress, new Function("presaleStatus",
                ListUtil.of(null),
                ListUtil.of(new Object[]{new TypeReference<Uint256>() {}})
        ));
        Uint256 status = (Uint256) infoResult.get(0);
        return status.getValue().toString();
    }


}
