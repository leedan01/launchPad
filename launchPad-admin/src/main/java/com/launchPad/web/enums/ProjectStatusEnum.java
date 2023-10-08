package com.launchPad.web.enums;

import lombok.Data;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/9/18  17:50
 * @Version 1.0
 */
public enum ProjectStatusEnum {


    NOT_BEGIN("0", "未开始"),
    IN_PROGRESS("1", "进行中"),
    SUCCESS("2","成功"),
    FAIL("3","失败");


    private final String code;
    private final String msg;

    ProjectStatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return msg;
    }
}
