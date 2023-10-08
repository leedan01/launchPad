package com.launchPad.web.enums;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/9/18  17:50
 * @Version 1.0
 */
public enum UserStatusEnum {


    JOIN("1", "用户参与项目"),
    SUCCESS_YES("2", "项目成功用户已领取"),
    FAIL_YES("3","项目失败已退出");


    private final String code;
    private final String msg;

    UserStatusEnum(String code, String msg) {
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
