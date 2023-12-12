package com.launchPad.web.domain.enuls;

import com.launchPad.common.annotation.Excel;
import com.launchPad.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 项目基本信息对象 tb_project
 *
 * @author ruoyi
 * @date 2023-08-23
 */
@Data
public class TbProjectEnuls extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    private String imgUrl;

    /** 介绍 */
    @Excel(name = "介绍")
    private String context;

    /** 支付token */
    @Excel(name = "支付token")
    private String baseToken;

    private String baseTokenSymbol;

    /** 售卖token */
    @Excel(name = "售卖token")
    private String saleToken;

    private String saleTokenSymbol;

    /** token价格 */
    @Excel(name = "token价格")
    private String tokenPrice;

    /** 最大基础代币购买 */
    @Excel(name = "最大基础代币购买")
    private String maxPerBuy;

    /** 售卖数量 */
    @Excel(name = "售卖数量")
    private String amount;

    /** 最大可募 */
    @Excel(name = "最大可募")
    private String hardCap;

    /** 最低可募 */
    @Excel(name = "最低可募")
    private String softCap;

    /** 当前已募 */
    @Excel(name = "当前已募")
    private String currentCap;

    /** 开始区块 */
    @Excel(name = "开始区块")
    private String startBlock;

    /** 结束区块 */
    @Excel(name = "结束区块")
    private String endBlock;

    /** 主资产添加百分比 */
    @Excel(name = "主资产添加百分比")
    private String percent;

    /** token添加池比例 */
    @Excel(name = "token添加池比例")
    private String listRate;

    /** 锁定天数 */
    @Excel(name = "锁定天数")
    private String lockPeriod;

    /** 是否为eth支付 */
    @Excel(name = "是否为eth支付")
    private Long ethFlag;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private Long status;

    /** 合约地址 */
    @Excel(name = "合约地址")
    private String projectAddress;

    /** 官网 */
    @Excel(name = "官网")
    private String website;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String telegram;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String twitter;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String discord;

    /**项目所有者*/
    private String projectOwner;

    /**uid唯一表示用于解析链上项目*/
    private Long uuid;
}
