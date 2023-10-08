package com.launchPad.web.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/9/18  15:35
 * @Version 1.0
 */
@Data
public class CreateProjectDTO {

    /**项目名称*/
    @NotBlank(message = "projectName can not be null" )
    private String projectName;

    /**logo集合*/
    private MultipartFile files;

    /**项目介绍*/
    private String context;

    /**官网*/
    private String website;

    /**tg*/
    private String telegram;

    /**twitter*/
    private String twitter;

    /**discord*/
    private String discord;

    /**token分布列表*/
    private String distributeList;

}
