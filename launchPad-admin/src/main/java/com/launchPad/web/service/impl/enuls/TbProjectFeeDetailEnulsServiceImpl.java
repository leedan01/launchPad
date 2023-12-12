package com.launchPad.web.service.impl.enuls;

import com.launchPad.common.utils.DateUtils;
import com.launchPad.web.domain.TbProjectFeeDetail;
import com.launchPad.web.domain.enuls.TbProjectFeeDetailEnuls;
import com.launchPad.web.mapper.TbProjectFeeDetailMapper;
import com.launchPad.web.mapper.enuls.TbProjectFeeDetailEnulsMapper;
import com.launchPad.web.service.ITbProjectFeeDetailService;
import com.launchPad.web.service.enuls.ITbProjectFeeDetailEnulsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目手续费详情Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-23
 */
@Service
public class TbProjectFeeDetailEnulsServiceImpl implements ITbProjectFeeDetailEnulsService
{
    @Autowired
    private TbProjectFeeDetailEnulsMapper tbProjectFeeDetailMapper;

    /**
     * 查询项目手续费详情
     *
     * @param id 项目手续费详情主键
     * @return 项目手续费详情
     */
    @Override
    public TbProjectFeeDetailEnuls selectTbProjectFeeDetailById(Long id)
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
    public List<TbProjectFeeDetailEnuls> selectTbProjectFeeDetailList(TbProjectFeeDetailEnuls tbProjectFeeDetail)
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
    public int insertTbProjectFeeDetail(TbProjectFeeDetailEnuls tbProjectFeeDetail)
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
    public int updateTbProjectFeeDetail(TbProjectFeeDetailEnuls tbProjectFeeDetail)
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
