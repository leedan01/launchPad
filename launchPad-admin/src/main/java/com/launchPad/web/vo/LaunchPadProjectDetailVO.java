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
public class LaunchPadProjectDetailVO {

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

    private List<ProjectTokenDistributedVO> percentList;


}
