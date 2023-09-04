package com.launchPad.web.service;

import java.util.List;
import com.launchPad.web.domain.TbProjectCreateDetail;

/**
 * weqeService接口
 * 
 * @author ruoyi
 * @date 2023-08-25
 */
public interface ITbProjectCreateDetailService 
{
    /**
     * 查询weqe
     * 
     * @param id weqe主键
     * @return weqe
     */
    public TbProjectCreateDetail selectTbProjectCreateDetailById(Long id);

    /**
     * 查询weqe列表
     * 
     * @param tbProjectCreateDetail weqe
     * @return weqe集合
     */
    public List<TbProjectCreateDetail> selectTbProjectCreateDetailList(TbProjectCreateDetail tbProjectCreateDetail);

    /**
     * 新增weqe
     * 
     * @param tbProjectCreateDetail weqe
     * @return 结果
     */
    public int insertTbProjectCreateDetail(TbProjectCreateDetail tbProjectCreateDetail);

    /**
     * 修改weqe
     * 
     * @param tbProjectCreateDetail weqe
     * @return 结果
     */
    public int updateTbProjectCreateDetail(TbProjectCreateDetail tbProjectCreateDetail);

    /**
     * 批量删除weqe
     * 
     * @param ids 需要删除的weqe主键集合
     * @return 结果
     */
    public int deleteTbProjectCreateDetailByIds(Long[] ids);

    /**
     * 删除weqe信息
     * 
     * @param id weqe主键
     * @return 结果
     */
    public int deleteTbProjectCreateDetailById(Long id);
}
