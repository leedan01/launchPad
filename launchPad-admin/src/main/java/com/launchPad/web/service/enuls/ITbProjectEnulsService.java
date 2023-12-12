package com.launchPad.web.service.enuls;

import com.launchPad.common.core.domain.AjaxResult;
import com.launchPad.web.domain.TbProject;
import com.launchPad.web.domain.enuls.TbProjectEnuls;
import com.launchPad.web.dto.CreateProjectDTO;
import com.launchPad.web.dto.QueryLaunchPadDTO;
import com.launchPad.web.dto.QueryMyPublishLaunchPadDTO;
import com.launchPad.web.vo.LaunchPadListVO;
import com.launchPad.web.vo.LaunchPadProjectDetailVO;
import com.launchPad.web.vo.MyPublishLaunchPadProjectDetailVO;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.Transaction;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;

/**
 * 项目基本信息Service接口
 *
 * @author ruoyi
 * @date 2023-08-23
 */
public interface ITbProjectEnulsService
{
    /**
     * 查询项目基本信息
     *
     * @param id 项目基本信息主键
     * @return 项目基本信息
     */
    public TbProjectEnuls selectTbProjectById(Long id);

    /**
     * 查询项目基本信息列表
     *
     * @param tbProject 项目基本信息
     * @return 项目基本信息集合
     */
    public List<TbProjectEnuls> selectTbProjectList(TbProjectEnuls tbProject);

    /**
     * 新增项目基本信息
     *
     * @param tbProject 项目基本信息
     * @return 结果
     */
    public int insertTbProject(TbProjectEnuls tbProject);

    /**
     * 修改项目基本信息
     *
     * @param tbProject 项目基本信息
     * @return 结果
     */
    public int updateTbProject(TbProjectEnuls tbProject);

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
     * 获取我发布的项目
     *
     *@Author leedan
     *@Description
     *@Date 2023/9/18
     *@param queryLaunchPadDTO
     *@return java.util.List<com.launchPad.web.vo.LaunchPadListVO>
     *@throws
     */
    public List<LaunchPadListVO>  getMyPublishLaunchPadList(QueryMyPublishLaunchPadDTO queryLaunchPadDTO);


    /**
     * 获取我发布的项目详情
     *
     *@Author leedan
     *@Description
     *@Date 2023/9/18
     *@param id
     *@return com.launchPad.web.vo.MyPublishLaunchPadProjectDetailVO
     *@throws
     */
    public MyPublishLaunchPadProjectDetailVO getMyPublishProjectDetail(String id) throws ParseException;
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
     * 新增项目
     *
     *@Author leedan
     *@Description
     *@Date 2023/9/18
     *@param createProjectDTO
     *@return int
     *@throws
     */
    public AjaxResult addProject(CreateProjectDTO createProjectDTO) throws Exception;

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

    /**
     * 用户领取
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/8
     *@param tx
     *@param height
     *@param logs
     *@return void
     *@throws
     */
    public void analysisUserWithdrawTokenProject( Transaction tx, BigInteger height,Log logs) throws Exception;


    /**
     * 用户退出
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/8
     *@param tx
     *@param height
     *@param logs
     *@return void
     *@throws
     */
    public void analysisUserWithdrawBaseTokenProject( Transaction tx, BigInteger height,Log logs) throws Exception;

    /**
     * 用户mint
     *
     *@Author leedan
     *@Description
     * 44 6/
     *@Date 2023/10/8
     *@param tx
     *@param height
     *@param logs
     *@return void
     *@throws
     */
    public void analysisUserMintProject( Transaction tx, BigInteger height,Log logs) throws Exception;


}
