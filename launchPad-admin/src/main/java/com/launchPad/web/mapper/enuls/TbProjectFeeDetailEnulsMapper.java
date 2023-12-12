package com.launchPad.web.mapper.enuls;

import com.launchPad.web.domain.TbProjectFeeDetail;
import com.launchPad.web.domain.enuls.TbProjectFeeDetailEnuls;

import java.util.List;

/**
 * 项目手续费详情Mapper接口
 *
 * @author ruoyi
 * @date 2023-08-23
 */
public interface TbProjectFeeDetailEnulsMapper
{
    /**
     * 查询项目手续费详情
     *
     * @param id 项目手续费详情主键
     * @return 项目手续费详情
     */
    public TbProjectFeeDetailEnuls selectTbProjectFeeDetailById(Long id);

    /**
     * 查询项目手续费详情列表
     *
     * @param tbProjectFeeDetail 项目手续费详情
     * @return 项目手续费详情集合
     */
    public List<TbProjectFeeDetailEnuls> selectTbProjectFeeDetailList(TbProjectFeeDetailEnuls tbProjectFeeDetail);

    /**
     * 新增项目手续费详情
     *
     * @param tbProjectFeeDetail 项目手续费详情
     * @return 结果
     */
    public int insertTbProjectFeeDetail(TbProjectFeeDetailEnuls tbProjectFeeDetail);

    /**
     * 修改项目手续费详情
     *
     * @param tbProjectFeeDetail 项目手续费详情
     * @return 结果
     */
    public int updateTbProjectFeeDetail(TbProjectFeeDetailEnuls tbProjectFeeDetail);

    /**
     * 删除项目手续费详情
     *
     * @param id 项目手续费详情主键
     * @return 结果
     */
    public int deleteTbProjectFeeDetailById(Long id);

    /**
     * 批量删除项目手续费详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbProjectFeeDetailByIds(Long[] ids);
}
