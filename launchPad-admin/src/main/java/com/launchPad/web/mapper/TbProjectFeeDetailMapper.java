package com.launchPad.web.mapper;

import java.util.List;
import com.launchPad.web.domain.TbProjectFeeDetail;

/**
 * 项目手续费详情Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-23
 */
public interface TbProjectFeeDetailMapper 
{
    /**
     * 查询项目手续费详情
     * 
     * @param id 项目手续费详情主键
     * @return 项目手续费详情
     */
    public TbProjectFeeDetail selectTbProjectFeeDetailById(Long id);

    /**
     * 查询项目手续费详情列表
     * 
     * @param tbProjectFeeDetail 项目手续费详情
     * @return 项目手续费详情集合
     */
    public List<TbProjectFeeDetail> selectTbProjectFeeDetailList(TbProjectFeeDetail tbProjectFeeDetail);

    /**
     * 新增项目手续费详情
     * 
     * @param tbProjectFeeDetail 项目手续费详情
     * @return 结果
     */
    public int insertTbProjectFeeDetail(TbProjectFeeDetail tbProjectFeeDetail);

    /**
     * 修改项目手续费详情
     * 
     * @param tbProjectFeeDetail 项目手续费详情
     * @return 结果
     */
    public int updateTbProjectFeeDetail(TbProjectFeeDetail tbProjectFeeDetail);

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
