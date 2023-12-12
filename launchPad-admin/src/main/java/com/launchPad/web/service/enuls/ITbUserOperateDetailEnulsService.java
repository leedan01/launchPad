package com.launchPad.web.service.enuls;

import com.launchPad.web.domain.TbUserOperateDetail;
import com.launchPad.web.domain.enuls.TbUserOperateDetailEnuls;

import java.util.List;

/**
 * 用户详情Service接口
 *
 * @author lee
 * @date 2023-10-07
 */
public interface ITbUserOperateDetailEnulsService
{
    /**
     * 查询用户详情
     *
     * @param id 用户详情主键
     * @return 用户详情
     */
    public TbUserOperateDetailEnuls selectTbUserOperateDetailById(Long id);

    /**
     * 查询用户详情列表
     *
     * @param tbUserOperateDetail 用户详情
     * @return 用户详情集合
     */
    public List<TbUserOperateDetailEnuls> selectTbUserOperateDetailList(TbUserOperateDetailEnuls tbUserOperateDetail);

    /**
     * 新增用户详情
     *
     * @param tbUserOperateDetail 用户详情
     * @return 结果
     */
    public int insertTbUserOperateDetail(TbUserOperateDetailEnuls tbUserOperateDetail);

    /**
     * 修改用户详情
     *
     * @param tbUserOperateDetail 用户详情
     * @return 结果
     */
    public int updateTbUserOperateDetail(TbUserOperateDetailEnuls tbUserOperateDetail);

    /**
     * 批量删除用户详情
     *
     * @param ids 需要删除的用户详情主键集合
     * @return 结果
     */
    public int deleteTbUserOperateDetailByIds(Long[] ids);

    /**
     * 删除用户详情信息
     *
     * @param id 用户详情主键
     * @return 结果
     */
    public int deleteTbUserOperateDetailById(Long id);
}
