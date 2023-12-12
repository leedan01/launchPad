package com.launchPad.web.service;


import com.launchPad.web.domain.TbBlockHeader;

import java.util.List;

/**
 * 区块同步，主要获取之前同步记录Service接口
 *
 * @author Unamano
 * @date 2022-09-02
 */
public interface ITbBlockHeaderService
{
    /**
     * 查询区块同步，主要获取之前同步记录
     *
     * @param height 区块同步，主要获取之前同步记录主键
     * @return 区块同步，主要获取之前同步记录
     */
    public TbBlockHeader selectTbBlockHeaderByHeight(Long height);

    /**
     * 查询区块同步，主要获取之前同步记录列表
     *
     * @param tbBlockHeader 区块同步，主要获取之前同步记录
     * @return 区块同步，主要获取之前同步记录集合
     */
    public List<TbBlockHeader> selectTbBlockHeaderList(TbBlockHeader tbBlockHeader);

    /**
     * 获取最新区块
     *
     *@Author leedan
     *@Description
     *@Date 2022/9/6
     *@param
     *@return io.unamano.web.domain.block.TbBlockHeaderEnuls
     *@throws
     */
    public TbBlockHeader selectLastBlockHeader();

    /**
     * 新增区块同步，主要获取之前同步记录
     *
     * @param tbBlockHeader 区块同步，主要获取之前同步记录
     * @return 结果
     */
    public int insertTbBlockHeader(TbBlockHeader tbBlockHeader);

    /**
     * 修改区块同步，主要获取之前同步记录
     *
     * @param tbBlockHeader 区块同步，主要获取之前同步记录
     * @return 结果
     */
    public int updateTbBlockHeader(TbBlockHeader tbBlockHeader);

    /**
     * 批量删除区块同步，主要获取之前同步记录
     *
     * @param heights 需要删除的区块同步，主要获取之前同步记录主键集合
     * @return 结果
     */
    public int deleteTbBlockHeaderByHeights(Long[] heights);

    /**
     * 删除区块同步，主要获取之前同步记录信息
     *
     * @param height 区块同步，主要获取之前同步记录主键
     * @return 结果
     */
    public int deleteTbBlockHeaderByHeight(Long height);
}
