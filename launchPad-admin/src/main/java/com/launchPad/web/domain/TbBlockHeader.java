package com.launchPad.web.domain;

import com.launchPad.common.annotation.Excel;
import com.launchPad.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigInteger;

/**
 * 区块同步，主要获取之前同步记录对象 tb_block_header
 *
 * @author Unamano
 * @date 2022-09-02
 */
public class TbBlockHeader extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 高度 */
    private Long height;

    /** 区块头hash */
    @Excel(name = "区块头hash")
    private String hash;

    /** 上一区块头hash */
    @Excel(name = "上一区块头hash")
    private String preHash;

    @Excel(name = "区块时间")
    private BigInteger blockTime;

    public void setBlockTime(BigInteger blockTime)
    {
        this.blockTime = blockTime;
    }

    public BigInteger getBlockTime()
    {
        return blockTime;
    }

    public void setHeight(Long height)
    {
        this.height = height;
    }

    public Long getHeight()
    {
        return height;
    }
    public void setHash(String hash)
    {
        this.hash = hash;
    }

    public String getHash()
    {
        return hash;
    }
    public void setPreHash(String preHash)
    {
        this.preHash = preHash;
    }

    public String getPreHash()
    {
        return preHash;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("height", getHeight())
            .append("hash", getHash())
            .append("preHash", getPreHash())
            .append("createTime", getCreateTime())
            .toString();
    }
}
