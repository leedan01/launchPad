package com.launchPad.web.service.impl;

import java.util.List;
import com.launchPad.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.launchPad.web.mapper.TbProjectCreateDetailMapper;
import com.launchPad.web.domain.TbProjectCreateDetail;
import com.launchPad.web.service.ITbProjectCreateDetailService;

/**
 * weqeService业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-25
 */
@Service
public class TbProjectCreateDetailServiceImpl implements ITbProjectCreateDetailService 
{
    @Autowired
    private TbProjectCreateDetailMapper tbProjectCreateDetailMapper;

    /**
     * 查询weqe
     * 
     * @param id weqe主键
     * @return weqe
     */
    @Override
    public TbProjectCreateDetail selectTbProjectCreateDetailById(Long id)
    {
        return tbProjectCreateDetailMapper.selectTbProjectCreateDetailById(id);
    }

    /**
     * 查询weqe列表
     * 
     * @param tbProjectCreateDetail weqe
     * @return weqe
     */
    @Override
    public List<TbProjectCreateDetail> selectTbProjectCreateDetailList(TbProjectCreateDetail tbProjectCreateDetail)
    {
        return tbProjectCreateDetailMapper.selectTbProjectCreateDetailList(tbProjectCreateDetail);
    }

    /**
     * 新增weqe
     * 
     * @param tbProjectCreateDetail weqe
     * @return 结果
     */
    @Override
    public int insertTbProjectCreateDetail(TbProjectCreateDetail tbProjectCreateDetail)
    {
        tbProjectCreateDetail.setCreateTime(DateUtils.getNowDate());
        return tbProjectCreateDetailMapper.insertTbProjectCreateDetail(tbProjectCreateDetail);
    }

    /**
     * 修改weqe
     * 
     * @param tbProjectCreateDetail weqe
     * @return 结果
     */
    @Override
    public int updateTbProjectCreateDetail(TbProjectCreateDetail tbProjectCreateDetail)
    {
        tbProjectCreateDetail.setUpdateTime(DateUtils.getNowDate());
        return tbProjectCreateDetailMapper.updateTbProjectCreateDetail(tbProjectCreateDetail);
    }

    /**
     * 批量删除weqe
     * 
     * @param ids 需要删除的weqe主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectCreateDetailByIds(Long[] ids)
    {
        return tbProjectCreateDetailMapper.deleteTbProjectCreateDetailByIds(ids);
    }

    /**
     * 删除weqe信息
     * 
     * @param id weqe主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectCreateDetailById(Long id)
    {
        return tbProjectCreateDetailMapper.deleteTbProjectCreateDetailById(id);
    }
}
