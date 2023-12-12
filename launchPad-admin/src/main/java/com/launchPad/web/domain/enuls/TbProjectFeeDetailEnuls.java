package com.launchPad.web.domain.enuls;

import com.launchPad.common.annotation.Excel;
import com.launchPad.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 项目手续费详情对象 tb_project_fee_detail
 *
 * @author ruoyi
 * @date 2023-08-23
 */
public class TbProjectFeeDetailEnuls extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 支付token费率 */
    @Excel(name = "支付token费率")
    private String baseTokenFee;

    /** 售卖token费率 */
    @Excel(name = "售卖token费率")
    private String saleTokenFee;

    /** 第三方费率 */
    @Excel(name = "第三方费率")
    private String referralFee;

    /** 支付token收费地址 */
    @Excel(name = "支付token收费地址")
    private String baseTokenFeeAddress;

    /** 售卖token收费地址 */
    @Excel(name = "售卖token收费地址")
    private String saleTokenFeeAddress;

    /** 第三方收费地址 */
    @Excel(name = "第三方收费地址")
    private String referralFeeAddress;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }

    public Long getProjectId()
    {
        return projectId;
    }
    public void setBaseTokenFee(String baseTokenFee)
    {
        this.baseTokenFee = baseTokenFee;
    }

    public String getBaseTokenFee()
    {
        return baseTokenFee;
    }
    public void setSaleTokenFee(String saleTokenFee)
    {
        this.saleTokenFee = saleTokenFee;
    }

    public String getSaleTokenFee()
    {
        return saleTokenFee;
    }
    public void setReferralFee(String referralFee)
    {
        this.referralFee = referralFee;
    }

    public String getReferralFee()
    {
        return referralFee;
    }
    public void setBaseTokenFeeAddress(String baseTokenFeeAddress)
    {
        this.baseTokenFeeAddress = baseTokenFeeAddress;
    }

    public String getBaseTokenFeeAddress()
    {
        return baseTokenFeeAddress;
    }
    public void setSaleTokenFeeAddress(String saleTokenFeeAddress)
    {
        this.saleTokenFeeAddress = saleTokenFeeAddress;
    }

    public String getSaleTokenFeeAddress()
    {
        return saleTokenFeeAddress;
    }
    public void setReferralFeeAddress(String referralFeeAddress)
    {
        this.referralFeeAddress = referralFeeAddress;
    }

    public String getReferralFeeAddress()
    {
        return referralFeeAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("baseTokenFee", getBaseTokenFee())
            .append("saleTokenFee", getSaleTokenFee())
            .append("referralFee", getReferralFee())
            .append("baseTokenFeeAddress", getBaseTokenFeeAddress())
            .append("saleTokenFeeAddress", getSaleTokenFeeAddress())
            .append("referralFeeAddress", getReferralFeeAddress())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
