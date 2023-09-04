package com.launchPad.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/8/24  15:24
 * @Version 1.0
 */
@Data
public class QueryLaunchPadDTO {

    @ApiModelProperty("0.未开始1.进行中2.完成3.失败")
    private String status;

    @ApiModelProperty("项目名称")
    private String projectName;

}
