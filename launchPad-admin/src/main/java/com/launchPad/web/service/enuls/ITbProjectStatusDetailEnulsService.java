package com.launchPad.web.service.enuls;

import com.launchPad.web.domain.TbProjectStatusDetail;
import com.launchPad.web.domain.enuls.TbProjectStatusDetailEnuls;

import java.util.List;

/**
 * 项目付款总计数据Service接口
 *
 * @author ruoyi
 * @date 2023-08-23
 */
public interface ITbProjectStatusDetailEnulsService
{
    /**
     * 查询项目付款总计数据
     *
     * @param id 项目付款总计数据主键
     * @return 项目付款总计数据
     */
    public TbProjectStatusDetailEnuls selectTbProjectStatusDetailById(Long id);

    /**
     * 查询项目付款总计数据列表
     *
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 项目付款总计数据集合
     */
    public List<TbProjectStatusDetailEnuls> selectTbProjectStatusDetailList(TbProjectStatusDetailEnuls tbProjectStatusDetail);

    /**
     * 新增项目付款总计数据
     *
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 结果
     */
    public int insertTbProjectStatusDetail(TbProjectStatusDetailEnuls tbProjectStatusDetail);

    /**
     * 修改项目付款总计数据
     *
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 结果
     */
    public int updateTbProjectStatusDetail(TbProjectStatusDetailEnuls tbProjectStatusDetail);

    /**
     * 批量删除项目付款总计数据
     *
     * @param ids 需要删除的项目付款总计数据主键集合
     * @return 结果
     */
    public int deleteTbProjectStatusDetailByIds(Long[] ids);

    /**
     * 删除项目付款总计数据信息
     *
     * @param id 项目付款总计数据主键
     * @return 结果
     */
    public int deleteTbProjectStatusDetailById(Long id);
}
