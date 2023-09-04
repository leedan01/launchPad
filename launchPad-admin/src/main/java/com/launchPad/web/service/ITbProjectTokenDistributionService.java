package com.launchPad.web.service;

import java.util.List;
import com.launchPad.web.domain.TbProjectTokenDistribution;

/**
 * webService接口
 * 
 * @author ruoyi
 * @date 2023-08-25
 */
public interface ITbProjectTokenDistributionService 
{
    /**
     * 查询web
     * 
     * @param id web主键
     * @return web
     */
    public TbProjectTokenDistribution selectTbProjectTokenDistributionById(Long id);

    /**
     * 查询web列表
     * 
     * @param tbProjectTokenDistribution web
     * @return web集合
     */
    public List<TbProjectTokenDistribution> selectTbProjectTokenDistributionList(TbProjectTokenDistribution tbProjectTokenDistribution);

    /**
     * 新增web
     * 
     * @param tbProjectTokenDistribution web
     * @return 结果
     */
    public int insertTbProjectTokenDistribution(TbProjectTokenDistribution tbProjectTokenDistribution);

    /**
     * 修改web
     * 
     * @param tbProjectTokenDistribution web
     * @return 结果
     */
    public int updateTbProjectTokenDistribution(TbProjectTokenDistribution tbProjectTokenDistribution);

    /**
     * 批量删除web
     * 
     * @param ids 需要删除的web主键集合
     * @return 结果
     */
    public int deleteTbProjectTokenDistributionByIds(Long[] ids);

    /**
     * 删除web信息
     * 
     * @param id web主键
     * @return 结果
     */
    public int deleteTbProjectTokenDistributionById(Long id);
}
