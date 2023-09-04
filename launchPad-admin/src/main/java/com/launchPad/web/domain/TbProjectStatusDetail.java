package com.launchPad.web.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.launchPad.common.annotation.Excel;
import com.launchPad.common.core.domain.BaseEntity;

/**
 * 项目付款总计数据对象 tb_project_status_detail
 *
 * @author ruoyi
 * @date 2023-08-23
 */
@Data
public class TbProjectStatusDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 是否只有白名单能参加 */
    @Excel(name = "是否只有白名单能参加")
    private boolean whiteOnly;

    /** 结束预售启用提款标识 */
    @Excel(name = "结束预售启用提款标识")
    private boolean lpGenerationComplete;

    /** 是否强制失败标识 */
    @Excel(name = "是否强制失败标识")
    private boolean forceFailed;

    /** 已经募集金额 */
    @Excel(name = "已经募集金额")
    private String totalBaseCollected;

    /** token已经售出 */
    @Excel(name = "token已经售出")
    private String totalTokensSold;

    /** token退出数量 */
    @Excel(name = "token退出数量")
    private String totalTokensWithdrawn;

    /** 支付token退出数量 */
    @Excel(name = "支付token退出数量")
    private String totalBaseWithdrawn;

    /** 预售第一轮 */
    @Excel(name = "预售第一轮")
    private String round1Length;

    /** 购买人数量 */
    @Excel(name = "购买人数量")
    private String numBuyers;


}
