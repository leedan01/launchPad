package com.launchPad.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/8/24  15:24
 * @Version 1.0
 */
@Data
public class QueryMyPublishLaunchPadDTO {

    @ApiModelProperty("0.未开始1.进行中2.完成3.失败")
    private String status;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("地址")
    @NotBlank(message = "address can not be null")
    private String address;

}
