package com.launchPad.web.service.impl;

import java.util.List;
import com.launchPad.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.launchPad.web.mapper.TbUserOperateDetailMapper;
import com.launchPad.web.domain.TbUserOperateDetail;
import com.launchPad.web.service.ITbUserOperateDetailService;

/**
 * 用户详情Service业务层处理
 * 
 * @author lee
 * @date 2023-10-07
 */
@Service
public class TbUserOperateDetailServiceImpl implements ITbUserOperateDetailService 
{
    @Autowired
    private TbUserOperateDetailMapper tbUserOperateDetailMapper;

    /**
     * 查询用户详情
     * 
     * @param id 用户详情主键
     * @return 用户详情
     */
    @Override
    public TbUserOperateDetail selectTbUserOperateDetailById(Long id)
    {
        return tbUserOperateDetailMapper.selectTbUserOperateDetailById(id);
    }

    /**
     * 查询用户详情列表
     * 
     * @param tbUserOperateDetail 用户详情
     * @return 用户详情
     */
    @Override
    public List<TbUserOperateDetail> selectTbUserOperateDetailList(TbUserOperateDetail tbUserOperateDetail)
    {
        return tbUserOperateDetailMapper.selectTbUserOperateDetailList(tbUserOperateDetail);
    }

    /**
     * 新增用户详情
     * 
     * @param tbUserOperateDetail 用户详情
     * @return 结果
     */
    @Override
    public int insertTbUserOperateDetail(TbUserOperateDetail tbUserOperateDetail)
    {
        tbUserOperateDetail.setCreateTime(DateUtils.getNowDate());
        return tbUserOperateDetailMapper.insertTbUserOperateDetail(tbUserOperateDetail);
    }

    /**
     * 修改用户详情
     * 
     * @param tbUserOperateDetail 用户详情
     * @return 结果
     */
    @Override
    public int updateTbUserOperateDetail(TbUserOperateDetail tbUserOperateDetail)
    {
        tbUserOperateDetail.setUpdateTime(DateUtils.getNowDate());
        return tbUserOperateDetailMapper.updateTbUserOperateDetail(tbUserOperateDetail);
    }

    /**
     * 批量删除用户详情
     * 
     * @param ids 需要删除的用户详情主键
     * @return 结果
     */
    @Override
    public int deleteTbUserOperateDetailByIds(Long[] ids)
    {
        return tbUserOperateDetailMapper.deleteTbUserOperateDetailByIds(ids);
    }

    /**
     * 删除用户详情信息
     * 
     * @param id 用户详情主键
     * @return 结果
     */
    @Override
    public int deleteTbUserOperateDetailById(Long id)
    {
        return tbUserOperateDetailMapper.deleteTbUserOperateDetailById(id);
    }
}
