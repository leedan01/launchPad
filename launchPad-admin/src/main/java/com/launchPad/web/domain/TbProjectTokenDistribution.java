package com.launchPad.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.launchPad.common.annotation.Excel;
import com.launchPad.common.core.domain.BaseEntity;

/**
 * web对象 tb_project_token_distribution
 * 
 * @author ruoyi
 * @date 2023-08-25
 */
public class TbProjectTokenDistribution extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 分布百分比 */
    @Excel(name = "分布百分比")
    private String percent;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPercent(String percent) 
    {
        this.percent = percent;
    }

    public String getPercent() 
    {
        return percent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("name", getName())
            .append("percent", getPercent())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
