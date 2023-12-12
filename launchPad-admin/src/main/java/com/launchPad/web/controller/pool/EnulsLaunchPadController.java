package com.launchPad.web.controller.pool;

import com.launchPad.common.core.controller.BaseController;
import com.launchPad.common.core.domain.AjaxResult;
import com.launchPad.common.core.page.TableDataInfo;
import com.launchPad.web.domain.emoji.TbEmoji;
import com.launchPad.web.dto.CreateProjectDTO;
import com.launchPad.web.dto.QueryLaunchPadDTO;
import com.launchPad.web.dto.QueryMyPublishLaunchPadDTO;
import com.launchPad.web.mapper.emoji.TbEmojiMapper;
import com.launchPad.web.service.ITbProjectService;
import com.launchPad.web.service.enuls.ITbProjectEnulsService;
import com.launchPad.web.vo.LaunchPadListVO;
import com.launchPad.web.vo.LaunchPadProjectDetailVO;
import com.launchPad.web.vo.MyPublishLaunchPadProjectDetailVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.util.List;

/**
 *
 *
 * @author leedan
 */
@RestController
@RequestMapping("/enuls/launch/pad")
public class EnulsLaunchPadController extends BaseController
{

    @Autowired
    private ITbProjectEnulsService projectService;


    /**
     * 获取项目列表
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/1
     *@param queryLaunchPadDTO
     *@return com.launchPad.common.core.page.TableDataInfo
     *@throws
     */
    @ApiOperation("获取项目列表")
    @GetMapping("/getLaunchPadList")
    public  TableDataInfo  getLaunchPadList(QueryLaunchPadDTO queryLaunchPadDTO)
    {
        startPage();
        List<LaunchPadListVO> list = projectService.getLaunchPadList(queryLaunchPadDTO);
        return getDataTable(list);
    }


    /**
     * 详情
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/1
     *@param id
     *@return com.launchPad.web.vo.LaunchPadProjectDetailVO
     *@throws
     */
    @ApiOperation("获取项目详情")
    @GetMapping("/getLaunchPadDetailById")
    public LaunchPadProjectDetailVO getLaunchPadDetailById(@NotBlank String  id)
    {
        return  projectService.getLaunchPadDetail(id);
    }

    /**
     *  新增项目
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/1
     *@param createProjectDTO
     *@return com.launchPad.common.core.domain.AjaxResult
     *@throws
     */
    @ApiOperation("新增项目")
    @PostMapping("/addProject")
    public AjaxResult addProject(@Valid CreateProjectDTO createProjectDTO) throws Exception {
       return projectService.addProject(createProjectDTO);
    }

    /**
     *  获取我发布的列表
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/1
     *@param queryLaunchPadDTO
     *@return com.launchPad.common.core.page.TableDataInfo
     *@throws
     */
    @ApiOperation("获取我发布的项目列表")
    @GetMapping("/getMyPublishLaunchPadList")
    public  TableDataInfo  getMyPublishLaunchPadList(QueryMyPublishLaunchPadDTO queryLaunchPadDTO)
    {
        startPage();
        List<LaunchPadListVO> list = projectService.getMyPublishLaunchPadList(queryLaunchPadDTO);
        return getDataTable(list);
    }


    /**
     * 获取我发布的项目详情
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/1
     *@param id
     *@return com.launchPad.web.vo.MyPublishLaunchPadProjectDetailVO
     *@throws
     */
    @ApiOperation("获取我发布的项目详情")
    @GetMapping("/getMyPublishLaunchPadDetail")
    public MyPublishLaunchPadProjectDetailVO getMyPublishLaunchPadDetail(@NotBlank String  id) throws ParseException {
        return  projectService.getMyPublishProjectDetail(id);
    }



}
