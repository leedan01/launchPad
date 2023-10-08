package com.launchPad.web.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/8/24  17:07
 * @Version 1.0
 */
@Data
public class MyPublishLaunchPadProjectDetailVO {

    private String id;

    private String projectName;

    private String imgUrl;

    private String status;

    private String website;

    private String telegram;

    private String twitter;

    private String discord;

    private String context;

    private String baseToken;

    private String hardCap;

    private String softCap;

    private String totalBaseCollected;

    private String baseTokenSymbol;

    private String saleToken;

    private String saleTokenSymbol;

    private String tokenPrice;

    private String poolPrice;

    private String percent;

    private String startBlock;

    private String endBlock;

    private String maxPerBuy;

    private String lockTime;

    private String projectAddress;


    private boolean nulsFlag;

    /**是否已经添加流动性0.未添加1.添加*/
    private String lpFlag;

    /**token分布列表*/
    private List<ProjectTokenDistributedVO> percentList;

    /**项目失败是否已经，退出售卖token标识*/
    private String withdrawSaleFlag;

    /**合约锁定地址*/
    private String lockerAddress;

    /**添加流动性时间*/
    private String addLiquidityTime;

}
