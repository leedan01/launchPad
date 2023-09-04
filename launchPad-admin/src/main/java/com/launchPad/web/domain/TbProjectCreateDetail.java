package com.launchPad.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.launchPad.common.annotation.Excel;
import com.launchPad.common.core.domain.BaseEntity;

/**
 * weqe对象 tb_project_create_detail
 * 
 * @author ruoyi
 * @date 2023-08-25
 */
public class TbProjectCreateDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 项目合约地址 */
    @Excel(name = "项目合约地址")
    private String projectAddress;

    /** 区块高度 */
    @Excel(name = "区块高度")
    private Long blockHeight;

    /** 交易hash */
    @Excel(name = "交易hash")
    private String txHash;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProjectAddress(String projectAddress) 
    {
        this.projectAddress = projectAddress;
    }

    public String getProjectAddress() 
    {
        return projectAddress;
    }
    public void setBlockHeight(Long blockHeight) 
    {
        this.blockHeight = blockHeight;
    }

    public Long getBlockHeight() 
    {
        return blockHeight;
    }
    public void setTxHash(String txHash) 
    {
        this.txHash = txHash;
    }

    public String getTxHash() 
    {
        return txHash;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectAddress", getProjectAddress())
            .append("blockHeight", getBlockHeight())
            .append("txHash", getTxHash())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
