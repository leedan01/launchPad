package com.launchPad.web.mapper;

import java.util.List;
import com.launchPad.web.domain.TbProjectStatusDetail;

/**
 * 项目付款总计数据Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-23
 */
public interface TbProjectStatusDetailMapper 
{
    /**
     * 查询项目付款总计数据
     * 
     * @param id 项目付款总计数据主键
     * @return 项目付款总计数据
     */
    public TbProjectStatusDetail selectTbProjectStatusDetailById(Long id);

    /**
     * 查询项目付款总计数据列表
     * 
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 项目付款总计数据集合
     */
    public List<TbProjectStatusDetail> selectTbProjectStatusDetailList(TbProjectStatusDetail tbProjectStatusDetail);

    /**
     * 新增项目付款总计数据
     * 
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 结果
     */
    public int insertTbProjectStatusDetail(TbProjectStatusDetail tbProjectStatusDetail);

    /**
     * 修改项目付款总计数据
     * 
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 结果
     */
    public int updateTbProjectStatusDetail(TbProjectStatusDetail tbProjectStatusDetail);

    /**
     * 删除项目付款总计数据
     * 
     * @param id 项目付款总计数据主键
     * @return 结果
     */
    public int deleteTbProjectStatusDetailById(Long id);

    /**
     * 批量删除项目付款总计数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbProjectStatusDetailByIds(Long[] ids);
}
