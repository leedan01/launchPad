package com.launchPad.web.domain.emoji;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.launchPad.common.annotation.Excel;
import com.launchPad.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 tb_emoji
 *
 * @author ruoyi
 * @date 2023-10-23
 */
public class TbEmoji
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 左边标识 */
    @Excel(name = "左边标识")
    private String leftEmojiCodepoint;

    /** 右边标识 */
    @Excel(name = "右边标识")
    private String rightEmojiCodepoint;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setLeftEmojiCodepoint(String leftEmojiCodepoint)
    {
        this.leftEmojiCodepoint = leftEmojiCodepoint;
    }

    public String getLeftEmojiCodepoint()
    {
        return leftEmojiCodepoint;
    }
    public void setRightEmojiCodepoint(String rightEmojiCodepoint)
    {
        this.rightEmojiCodepoint = rightEmojiCodepoint;
    }

    public String getRightEmojiCodepoint()
    {
        return rightEmojiCodepoint;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("leftEmojiCodepoint", getLeftEmojiCodepoint())
            .append("rightEmojiCodepoint", getRightEmojiCodepoint())
            .toString();
    }
}
