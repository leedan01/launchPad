package com.launchPad.web.enums;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/9/18  17:50
 * @Version 1.0
 */
public enum ProjectAddLiquidityEnum {


    NO("0", "未添加"),
    YES("1","已添加");


    private final String code;
    private final String msg;

    ProjectAddLiquidityEnum(String code, String msg) {
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
