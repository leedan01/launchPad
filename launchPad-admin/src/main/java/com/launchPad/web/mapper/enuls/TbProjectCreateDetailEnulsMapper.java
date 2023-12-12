package com.launchPad.web.mapper.enuls;

import com.launchPad.web.domain.TbProjectCreateDetail;
import com.launchPad.web.domain.enuls.TbProjectCreateDetailEnuls;

import java.util.List;

/**
 * weqeMapper接口
 *
 * @author ruoyi
 * @date 2023-08-25
 */
public interface TbProjectCreateDetailEnulsMapper
{
    /**
     * 查询weqe
     *
     * @param id weqe主键
     * @return weqe
     */
    public TbProjectCreateDetailEnuls selectTbProjectCreateDetailById(Long id);

    /**
     * 查询weqe列表
     *
     * @param tbProjectCreateDetail weqe
     * @return weqe集合
     */
    public List<TbProjectCreateDetailEnuls> selectTbProjectCreateDetailList(TbProjectCreateDetailEnuls tbProjectCreateDetail);

    /**
     * 新增weqe
     *
     * @param tbProjectCreateDetail weqe
     * @return 结果
     */
    public int insertTbProjectCreateDetail(TbProjectCreateDetailEnuls tbProjectCreateDetail);

    /**
     * 修改weqe
     *
     * @param tbProjectCreateDetail weqe
     * @return 结果
     */
    public int updateTbProjectCreateDetail(TbProjectCreateDetailEnuls tbProjectCreateDetail);

    /**
     * 删除weqe
     *
     * @param id weqe主键
     * @return 结果
     */
    public int deleteTbProjectCreateDetailById(Long id);

    /**
     * 批量删除weqe
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbProjectCreateDetailByIds(Long[] ids);
}
