package com.launchPad.web.controller.pool;

import com.launchPad.common.annotation.Log;
import com.launchPad.common.core.controller.BaseController;
import com.launchPad.common.core.domain.AjaxResult;
import com.launchPad.common.core.page.TableDataInfo;
import com.launchPad.common.enums.BusinessType;
import com.launchPad.common.utils.poi.ExcelUtil;
import com.launchPad.system.domain.SysConfig;
import com.launchPad.system.service.ISysConfigService;
import com.launchPad.web.dto.CreateProjectDTO;
import com.launchPad.web.dto.QueryLaunchPadDTO;
import com.launchPad.web.dto.QueryMyPublishLaunchPadDTO;
import com.launchPad.web.service.ITbProjectService;
import com.launchPad.web.vo.LaunchPadListVO;
import com.launchPad.web.vo.LaunchPadProjectDetailVO;
import com.launchPad.web.vo.MyPublishLaunchPadProjectDetailVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 *
 *
 * @author leedan
 */
@RestController
@RequestMapping("/launch/pad")
public class LaunchPadController extends BaseController
{

    @Autowired
    private ITbProjectService projectService;

    @ApiOperation("获取项目列表")
    @GetMapping("/getLaunchPadList")
    public  TableDataInfo  getLaunchPadList(QueryLaunchPadDTO queryLaunchPadDTO)
    {
        startPage();
        List<LaunchPadListVO> list = projectService.getLaunchPadList(queryLaunchPadDTO);
        return getDataTable(list);
    }


    @ApiOperation("获取项目详情")
    @GetMapping("/getLaunchPadDetailById")
    public LaunchPadProjectDetailVO getLaunchPadDetailById(@NotBlank String  id)
    {
        return  projectService.getLaunchPadDetail(id);
    }


    @ApiOperation("新增项目")
    @PostMapping("/addProject")
    public AjaxResult addProject(@Valid CreateProjectDTO createProjectDTO) throws IOException {
       return AjaxResult.success("success",projectService.addProject(createProjectDTO));
    }


    @ApiOperation("获取我发布的项目列表")
    @GetMapping("/getMyPublishLaunchPadList")
    public  TableDataInfo  getMyPublishLaunchPadList(QueryMyPublishLaunchPadDTO queryLaunchPadDTO)
    {
        startPage();
        List<LaunchPadListVO> list = projectService.getMyPublishLaunchPadList(queryLaunchPadDTO);
        return getDataTable(list);
    }

    @ApiOperation("获取我发布的项目详情")
    @GetMapping("/getMyPublishLaunchPadDetail")
    public MyPublishLaunchPadProjectDetailVO getMyPublishLaunchPadDetail(@NotBlank String  id) throws ParseException {
        return  projectService.getMyPublishProjectDetail(id);
    }








}
