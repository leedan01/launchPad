package com.launchPad.web.service.impl.enuls;

import com.launchPad.common.utils.DateUtils;
import com.launchPad.web.domain.TbProjectStatusDetail;
import com.launchPad.web.domain.enuls.TbProjectStatusDetailEnuls;
import com.launchPad.web.mapper.TbProjectStatusDetailMapper;
import com.launchPad.web.mapper.enuls.TbProjectStatusDetailEnulsMapper;
import com.launchPad.web.service.ITbProjectStatusDetailService;
import com.launchPad.web.service.enuls.ITbProjectStatusDetailEnulsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目付款总计数据Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-23
 */
@Service
public class TbProjectStatusDetailEnulsServiceImpl implements ITbProjectStatusDetailEnulsService
{
    @Autowired
    private TbProjectStatusDetailEnulsMapper tbProjectStatusDetailMapper;

    /**
     * 查询项目付款总计数据
     *
     * @param id 项目付款总计数据主键
     * @return 项目付款总计数据
     */
    @Override
    public TbProjectStatusDetailEnuls selectTbProjectStatusDetailById(Long id)
    {
        return tbProjectStatusDetailMapper.selectTbProjectStatusDetailById(id);
    }

    /**
     * 查询项目付款总计数据列表
     *
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 项目付款总计数据
     */
    @Override
    public List<TbProjectStatusDetailEnuls> selectTbProjectStatusDetailList(TbProjectStatusDetailEnuls tbProjectStatusDetail)
    {
        return tbProjectStatusDetailMapper.selectTbProjectStatusDetailList(tbProjectStatusDetail);
    }

    /**
     * 新增项目付款总计数据
     *
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 结果
     */
    @Override
    public int insertTbProjectStatusDetail(TbProjectStatusDetailEnuls tbProjectStatusDetail)
    {
        tbProjectStatusDetail.setCreateTime(DateUtils.getNowDate());
        return tbProjectStatusDetailMapper.insertTbProjectStatusDetail(tbProjectStatusDetail);
    }

    /**
     * 修改项目付款总计数据
     *
     * @param tbProjectStatusDetail 项目付款总计数据
     * @return 结果
     */
    @Override
    public int updateTbProjectStatusDetail(TbProjectStatusDetailEnuls tbProjectStatusDetail)
    {
        tbProjectStatusDetail.setUpdateTime(DateUtils.getNowDate());
        return tbProjectStatusDetailMapper.updateTbProjectStatusDetail(tbProjectStatusDetail);
    }

    /**
     * 批量删除项目付款总计数据
     *
     * @param ids 需要删除的项目付款总计数据主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectStatusDetailByIds(Long[] ids)
    {
        return tbProjectStatusDetailMapper.deleteTbProjectStatusDetailByIds(ids);
    }

    /**
     * 删除项目付款总计数据信息
     *
     * @param id 项目付款总计数据主键
     * @return 结果
     */
    @Override
    public int deleteTbProjectStatusDetailById(Long id)
    {
        return tbProjectStatusDetailMapper.deleteTbProjectStatusDetailById(id);
    }
}
