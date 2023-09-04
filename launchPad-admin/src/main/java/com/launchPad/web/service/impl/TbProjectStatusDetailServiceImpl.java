package com.launchPad.web.service.impl;

import java.util.List;
import com.launchPad.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.launchPad.web.mapper.TbProjectStatusDetailMapper;
import com.launchPad.web.domain.TbProjectStatusDetail;
import com.launchPad.web.service.ITbProjectStatusDetailService;

/**
 * 项目付款总计数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-23
 */
@Service
public class TbProjectStatusDetailServiceImpl implements ITbProjectStatusDetailService 
{
    @Autowired
    private TbProjectStatusDetailMapper tbProjectStatusDetailMapper;

    /**
     * 查询项目付款总计数据
     * 
     * @param id 项目付款总计数据主键
     * @return 项目付款总计数据
     */
    @Override
    public TbProjectStatusDetail selectTbProjectStatusDetailById(Long id)
    {
        return tbProjectStatusDetailMapper.selectTbProjectStatusDetailById(id);
    }

    /**
     * 查询项目付款总计数据列表
     * 
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 项目付款总计数据
     */
    @Override
    public List<TbProjectStatusDetail> selectTbProjectStatusDetailList(TbProjectStatusDetail tbProjectStatusDetail)
    {
        return tbProjectStatusDetailMapper.selectTbProjectStatusDetailList(tbProjectStatusDetail);
    }

    /**
     * 新增项目付款总计数据
     * 
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 结果
     */
    @Override
    public int insertTbProjectStatusDetail(TbProjectStatusDetail tbProjectStatusDetail)
    {
        tbProjectStatusDetail.setCreateTime(DateUtils.getNowDate());
        return tbProjectStatusDetailMapper.insertTbProjectStatusDetail(tbProjectStatusDetail);
    }

    /**
     * 修改项目付款总计数据
     * 
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 结果
     */
    @Override
    public int updateTbProjectStatusDetail(TbProjectStatusDetail tbProjectStatusDetail)
    {
        tbProjectStatusDetail.setUpdateTime(DateUtils.getNowDate());
        return tbProjectStatusDetailMapper.updateTbProjectStatusDetail(tbProjectStatusDetail);
    }

    /**
     * 批量删除项目付款总计数据
     * 
     * @param ids 需要删除的项目付款总计数据主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectStatusDetailByIds(Long[] ids)
    {
        return tbProjectStatusDetailMapper.deleteTbProjectStatusDetailByIds(ids);
    }

    /**
     * 删除项目付款总计数据信息
     * 
     * @param id 项目付款总计数据主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectStatusDetailById(Long id)
    {
        return tbProjectStatusDetailMapper.deleteTbProjectStatusDetailById(id);
    }
}
