package com.launchPad.web.vo;

import lombok.Data;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/8/24  14:57
 * @Version 1.0
 */
@Data
public class LaunchPadListVO {


    private String id;

    /**项目名称*/
    private String projectName;

    /**项目图标*/
    private String imgUrl;

    private String status;

    private String baseTokenSymbol;

    private String saleTokenSymbol;

    /**售卖价格*/
    private String salePrice;

    /**加池子价格*/
    private String poolPrice;

    /**最大募集金额*/
    private String hardCap;

    /**已经募集金额*/
    private String totalBaseCollected;

    private String lockTime;




}
