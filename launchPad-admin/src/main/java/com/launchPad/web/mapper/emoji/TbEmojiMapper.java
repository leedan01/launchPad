package com.launchPad.web.mapper.emoji;

import com.launchPad.web.domain.emoji.TbEmoji;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-10-23
 */
public interface TbEmojiMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TbEmoji selectTbEmojiById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tbEmoji 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TbEmoji> selectTbEmojiList(TbEmoji tbEmoji);

    public List<TbEmoji> selectByEmoji(@Param("codePoint")String codePoint);


    /**
     * 新增【请填写功能名称】
     *
     * @param tbEmoji 【请填写功能名称】
     * @return 结果
     */
    public int insertTbEmoji(TbEmoji tbEmoji);

    /**
     * 修改【请填写功能名称】
     *
     * @param tbEmoji 【请填写功能名称】
     * @return 结果
     */
    public int updateTbEmoji(TbEmoji tbEmoji);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTbEmojiById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbEmojiByIds(Long[] ids);
}
