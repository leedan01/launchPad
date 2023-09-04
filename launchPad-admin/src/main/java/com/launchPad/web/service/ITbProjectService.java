package com.launchPad.web.service;

import java.math.BigInteger;
import java.util.List;
import com.launchPad.web.domain.TbProject;
import com.launchPad.web.dto.QueryLaunchPadDTO;
import com.launchPad.web.vo.LaunchPadListVO;
import com.launchPad.web.vo.LaunchPadProjectDetailVO;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.Transaction;

/**
 * 项目基本信息Service接口
 *
 * @author ruoyi
 * @date 2023-08-23
 */
public interface ITbProjectService
{
    /**
     * 查询项目基本信息
     *
     * @param id 项目基本信息主键
     * @return 项目基本信息
     */
    public TbProject selectTbProjectById(Long id);

    /**
     * 查询项目基本信息列表
     *
     * @param tbProject 项目基本信息
     * @return 项目基本信息集合
     */
    public List<TbProject> selectTbProjectList(TbProject tbProject);

    /**
     * 新增项目基本信息
     *
     * @param tbProject 项目基本信息
     * @return 结果
     */
    public int insertTbProject(TbProject tbProject);

    /**
     * 修改项目基本信息
     *
     * @param tbProject 项目基本信息
     * @return 结果
     */
    public int updateTbProject(TbProject tbProject);

    /**
     * 批量删除项目基本信息
     *
     * @param ids 需要删除的项目基本信息主键集合
     * @return 结果
     */
    public int deleteTbProjectByIds(Long[] ids);

    /**
     * 删除项目基本信息信息
     *
     * @param id 项目基本信息主键
     * @return 结果
     */
    public int deleteTbProjectById(Long id);

    /**
     * 获取项目列表
     *
     *@Author leedan
     *@Description
     *@Date 2023/8/24
     *@param queryLaunchPadDTO
     *@return java.util.List<com.launchPad.web.vo.LaunchPadListVO>
     *@throws
     */
    public List<LaunchPadListVO>  getLaunchPadList(QueryLaunchPadDTO queryLaunchPadDTO);

    /**
     * 根据项目id获取详情
     *
     *@Author leedan
     *@Description
     *@Date 2023/8/25
     *@param id
     *@return com.launchPad.web.vo.LaunchPadProjectDetailVO
     *@throws
     */
    public LaunchPadProjectDetailVO getLaunchPadDetail(String id);

    /**
     * 从区块解析新增项目
     *
     *@Author leedan
     *@Description
     *@Date 2023/8/25
     *@param tx
     *@param height
     *@param logs
     *@return void
     *@throws
     */
    public void analysisCreateProject( Transaction tx, BigInteger height,List<Log> logs) throws Exception;

}
