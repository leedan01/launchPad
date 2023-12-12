package com.launchPad.web.mapper.enuls;

import com.launchPad.web.domain.TbProjectTokenDistribution;
import com.launchPad.web.domain.enuls.TbProjectTokenDistributionEnuls;

import java.util.List;

/**
 * webMapper接口
 *
 * @author ruoyi
 * @date 2023-08-25
 */
public interface TbProjectTokenDistributionEnulsMapper
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
     * 删除web
     *
     * @param id web主键
     * @return 结果
     */
    public int deleteTbProjectTokenDistributionById(Long id);

    /**
     * 批量删除web
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbProjectTokenDistributionByIds(Long[] ids);
}
