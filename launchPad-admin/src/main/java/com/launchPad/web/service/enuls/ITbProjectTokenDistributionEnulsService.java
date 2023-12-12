package com.launchPad.web.service.enuls;

import com.launchPad.web.domain.TbProjectTokenDistribution;
import com.launchPad.web.domain.enuls.TbProjectTokenDistributionEnuls;

import java.util.List;

/**
 * webService接口
 *
 * @author ruoyi
 * @date 2023-08-25
 */
public interface ITbProjectTokenDistributionEnulsService
{
    /**
     * 查询web
     *
     * @param id web主键
     * @return web
     */
    public TbProjectTokenDistributionEnuls selectTbProjectTokenDistributionById(Long id);

    /**
     * 查询web列表
     *
     * @param tbProjectTokenDistribution web
     * @return web集合
     */
    public List<TbProjectTokenDistributionEnuls> selectTbProjectTokenDistributionList(TbProjectTokenDistributionEnuls tbProjectTokenDistribution);

    /**
     * 新增web
     *
     * @param tbProjectTokenDistribution web
     * @return 结果
     */
    public int insertTbProjectTokenDistribution(TbProjectTokenDistributionEnuls tbProjectTokenDistribution);

    /**
     * 修改web
     *
     * @param tbProjectTokenDistribution web
     * @return 结果
     */
    public int updateTbProjectTokenDistribution(TbProjectTokenDistributionEnuls tbProjectTokenDistribution);

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
