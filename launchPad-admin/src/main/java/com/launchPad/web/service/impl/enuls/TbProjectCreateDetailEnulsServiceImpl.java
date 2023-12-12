package com.launchPad.web.service.impl.enuls;

import com.launchPad.common.utils.DateUtils;
import com.launchPad.web.domain.TbProjectCreateDetail;
import com.launchPad.web.domain.enuls.TbProjectCreateDetailEnuls;
import com.launchPad.web.mapper.TbProjectCreateDetailMapper;
import com.launchPad.web.mapper.enuls.TbProjectCreateDetailEnulsMapper;
import com.launchPad.web.service.ITbProjectCreateDetailService;
import com.launchPad.web.service.enuls.ITbProjectCreateDetailEnulsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * weqeService业务层处理
 *
 * @author ruoyi
 * @date 2023-08-25
 */
@Service
public class TbProjectCreateDetailEnulsServiceImpl implements ITbProjectCreateDetailEnulsService
{
    @Autowired
    private TbProjectCreateDetailEnulsMapper tbProjectCreateDetailMapper;

    /**
     * 查询weqe
     *
     * @param id weqe主键
     * @return weqe
     */
    @Override
    public TbProjectCreateDetailEnuls selectTbProjectCreateDetailById(Long id)
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
    public List<TbProjectCreateDetailEnuls> selectTbProjectCreateDetailList(TbProjectCreateDetailEnuls tbProjectCreateDetail)
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
    public int insertTbProjectCreateDetail(TbProjectCreateDetailEnuls tbProjectCreateDetail)
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
    public int updateTbProjectCreateDetail(TbProjectCreateDetailEnuls tbProjectCreateDetail)
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
