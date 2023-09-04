package com.launchPad.web.service.impl;

import com.launchPad.common.utils.DateUtils;
import com.launchPad.web.domain.TbBlockHeader;
import com.launchPad.web.mapper.TbBlockHeaderMapper;
import com.launchPad.web.service.ITbBlockHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 区块同步，主要获取之前同步记录Service业务层处理
 *
 * @author Unamano
 * @date 2022-09-02
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbBlockHeaderServiceImpl implements ITbBlockHeaderService {
    @Autowired
    private TbBlockHeaderMapper tbBlockHeaderMapper;

    /**
     * 查询区块同步，主要获取之前同步记录
     *
     * @param height 区块同步，主要获取之前同步记录主键
     * @return 区块同步，主要获取之前同步记录
     */
    @Override
    public TbBlockHeader selectTbBlockHeaderByHeight(Long height) {
        return tbBlockHeaderMapper.selectTbBlockHeaderByHeight(height);
    }

    /**
     * 查询区块同步，主要获取之前同步记录列表
     *
     * @param tbBlockHeader 区块同步，主要获取之前同步记录
     * @return 区块同步，主要获取之前同步记录
     */
    @Override
    public List<TbBlockHeader> selectTbBlockHeaderList(TbBlockHeader tbBlockHeader) {
        return tbBlockHeaderMapper.selectTbBlockHeaderList(tbBlockHeader);
    }

    /**
     * 获取最新区块
     *
     * @param
     * @return io.unamano.web.domain.block.TbBlockHeader
     * @throws
     * @Author leedan
     * @Description
     * @Date 2022/9/6
     */
    @Override
    public TbBlockHeader selectLastBlockHeader() {
        return tbBlockHeaderMapper.selectLastBlockHeader();
    }


    /**
     * 新增区块同步，主要获取之前同步记录
     *
     * @param tbBlockHeader 区块同步，主要获取之前同步记录
     * @return 结果
     */
    @Override
    public int insertTbBlockHeader(TbBlockHeader tbBlockHeader) {
        tbBlockHeader.setCreateTime(DateUtils.getNowDate());
        return tbBlockHeaderMapper.insertTbBlockHeader(tbBlockHeader);
    }

    /**
     * 修改区块同步，主要获取之前同步记录
     *
     * @param tbBlockHeader 区块同步，主要获取之前同步记录
     * @return 结果
     */
    @Override
    public int updateTbBlockHeader(TbBlockHeader tbBlockHeader) {
        return tbBlockHeaderMapper.updateTbBlockHeader(tbBlockHeader);
    }

    /**
     * 批量删除区块同步，主要获取之前同步记录
     *
     * @param heights 需要删除的区块同步，主要获取之前同步记录主键
     * @return 结果
     */
    @Override
    public int deleteTbBlockHeaderByHeights(Long[] heights) {
        return tbBlockHeaderMapper.deleteTbBlockHeaderByHeights(heights);
    }

    /**
     * 删除区块同步，主要获取之前同步记录信息
     *
     * @param height 区块同步，主要获取之前同步记录主键
     * @return 结果
     */
    @Override
    public int deleteTbBlockHeaderByHeight(Long height) {
        return tbBlockHeaderMapper.deleteTbBlockHeaderByHeight(height);
    }
}
