package com.launchPad.web.service.impl;

import java.util.List;
import com.launchPad.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.launchPad.web.mapper.TbProjectTokenDistributionMapper;
import com.launchPad.web.domain.TbProjectTokenDistribution;
import com.launchPad.web.service.ITbProjectTokenDistributionService;

/**
 * webService业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-25
 */
@Service
public class TbProjectTokenDistributionServiceImpl implements ITbProjectTokenDistributionService 
{
    @Autowired
    private TbProjectTokenDistributionMapper tbProjectTokenDistributionMapper;

    /**
     * 查询web
     * 
     * @param id web主键
     * @return web
     */
    @Override
    public TbProjectTokenDistribution selectTbProjectTokenDistributionById(Long id)
    {
        return tbProjectTokenDistributionMapper.selectTbProjectTokenDistributionById(id);
    }

    /**
     * 查询web列表
     * 
     * @param tbProjectTokenDistribution web
     * @return web
     */
    @Override
    public List<TbProjectTokenDistribution> selectTbProjectTokenDistributionList(TbProjectTokenDistribution tbProjectTokenDistribution)
    {
        return tbProjectTokenDistributionMapper.selectTbProjectTokenDistributionList(tbProjectTokenDistribution);
    }

    /**
     * 新增web
     * 
     * @param tbProjectTokenDistribution web
     * @return 结果
     */
    @Override
    public int insertTbProjectTokenDistribution(TbProjectTokenDistribution tbProjectTokenDistribution)
    {
        tbProjectTokenDistribution.setCreateTime(DateUtils.getNowDate());
        return tbProjectTokenDistributionMapper.insertTbProjectTokenDistribution(tbProjectTokenDistribution);
    }

    /**
     * 修改web
     * 
     * @param tbProjectTokenDistribution web
     * @return 结果
     */
    @Override
    public int updateTbProjectTokenDistribution(TbProjectTokenDistribution tbProjectTokenDistribution)
    {
        tbProjectTokenDistribution.setUpdateTime(DateUtils.getNowDate());
        return tbProjectTokenDistributionMapper.updateTbProjectTokenDistribution(tbProjectTokenDistribution);
    }

    /**
     * 批量删除web
     * 
     * @param ids 需要删除的web主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectTokenDistributionByIds(Long[] ids)
    {
        return tbProjectTokenDistributionMapper.deleteTbProjectTokenDistributionByIds(ids);
    }

    /**
     * 删除web信息
     * 
     * @param id web主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectTokenDistributionById(Long id)
    {
        return tbProjectTokenDistributionMapper.deleteTbProjectTokenDistributionById(id);
    }
}
