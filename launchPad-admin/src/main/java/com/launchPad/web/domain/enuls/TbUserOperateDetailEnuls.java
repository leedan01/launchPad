package com.launchPad.web.domain.enuls;

import com.launchPad.common.annotation.Excel;
import com.launchPad.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户详情对象 tb_user_operate_detail
 *
 * @author lee
 * @date 2023-10-07
 */
public class TbUserOperateDetailEnuls extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 用户地址 */
    @Excel(name = "用户地址")
    private String userAddress;

    /** 用户状态（1.用户已参与2.项目成功领取3.项目失败退出） */
    @Excel(name = "用户状态", readConverterExp = "1.已参与2.项目成功领取3.项目失败退出")
    private Long status;

    /** 操作类型（1.铸造2.领取3.退出） */
    @Excel(name = "操作类型", readConverterExp = "1=.铸造2.领取3.退出")
    private Long type;

    /** 交易hash */
    @Excel(name = "交易hash")
    private String txHash;

    /** 数量 */
    @Excel(name = "数量")
    private String amount;

    /** 项目地址 */
    @Excel(name = "项目地址")
    private String projectAddress;

    /** 区块高度 */
    @Excel(name = "区块高度")
    private String blockHeight;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserAddress(String userAddress)
    {
        this.userAddress = userAddress;
    }

    public String getUserAddress()
    {
        return userAddress;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setType(Long type)
    {
        this.type = type;
    }

    public Long getType()
    {
        return type;
    }
    public void setTxHash(String txHash)
    {
        this.txHash = txHash;
    }

    public String getTxHash()
    {
        return txHash;
    }
    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getAmount()
    {
        return amount;
    }
    public void setProjectAddress(String projectAddress)
    {
        this.projectAddress = projectAddress;
    }

    public String getProjectAddress()
    {
        return projectAddress;
    }
    public void setBlockHeight(String blockHeight)
    {
        this.blockHeight = blockHeight;
    }

    public String getBlockHeight()
    {
        return blockHeight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userAddress", getUserAddress())
            .append("status", getStatus())
            .append("type", getType())
            .append("txHash", getTxHash())
            .append("amount", getAmount())
            .append("projectAddress", getProjectAddress())
            .append("blockHeight", getBlockHeight())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
