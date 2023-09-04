package com.launchPad.web.service.impl;

import java.util.List;
import com.launchPad.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.launchPad.web.mapper.TbProjectFeeDetailMapper;
import com.launchPad.web.domain.TbProjectFeeDetail;
import com.launchPad.web.service.ITbProjectFeeDetailService;

/**
 * 项目手续费详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-23
 */
@Service
public class TbProjectFeeDetailServiceImpl implements ITbProjectFeeDetailService 
{
    @Autowired
    private TbProjectFeeDetailMapper tbProjectFeeDetailMapper;

    /**
     * 查询项目手续费详情
     * 
     * @param id 项目手续费详情主键
     * @return 项目手续费详情
     */
    @Override
    public TbProjectFeeDetail selectTbProjectFeeDetailById(Long id)
    {
        return tbProjectFeeDetailMapper.selectTbProjectFeeDetailById(id);
    }

    /**
     * 查询项目手续费详情列表
     * 
     * @param tbProjectFeeDetail 项目手续费详情
     * @return 项目手续费详情
     */
    @Override
    public List<TbProjectFeeDetail> selectTbProjectFeeDetailList(TbProjectFeeDetail tbProjectFeeDetail)
    {
        return tbProjectFeeDetailMapper.selectTbProjectFeeDetailList(tbProjectFeeDetail);
    }

    /**
     * 新增项目手续费详情
     * 
     * @param tbProjectFeeDetail 项目手续费详情
     * @return 结果
     */
    @Override
    public int insertTbProjectFeeDetail(TbProjectFeeDetail tbProjectFeeDetail)
    {
        tbProjectFeeDetail.setCreateTime(DateUtils.getNowDate());
        return tbProjectFeeDetailMapper.insertTbProjectFeeDetail(tbProjectFeeDetail);
    }

    /**
     * 修改项目手续费详情
     * 
     * @param tbProjectFeeDetail 项目手续费详情
     * @return 结果
     */
    @Override
    public int updateTbProjectFeeDetail(TbProjectFeeDetail tbProjectFeeDetail)
    {
        tbProjectFeeDetail.setUpdateTime(DateUtils.getNowDate());
        return tbProjectFeeDetailMapper.updateTbProjectFeeDetail(tbProjectFeeDetail);
    }

    /**
     * 批量删除项目手续费详情
     * 
     * @param ids 需要删除的项目手续费详情主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectFeeDetailByIds(Long[] ids)
    {
        return tbProjectFeeDetailMapper.deleteTbProjectFeeDetailByIds(ids);
    }

    /**
     * 删除项目手续费详情信息
     * 
     * @param id 项目手续费详情主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectFeeDetailById(Long id)
    {
        return tbProjectFeeDetailMapper.deleteTbProjectFeeDetailById(id);
    }
}
