package com.fenyun.common.base.base.enums;

/**
 * @author dupihua
 */

public enum EmErrorMsg {

    /**
     * 系统异常
     */
    FAIL("系统异常", Integer.valueOf(0)),

    SUCCESS("返回成功", Integer.valueOf(1));

    private String name;

    private Integer index;

    public String getName() {
        return this.name;
    }

    public Integer getIndex() {
        return this.index;
    }

    EmErrorMsg(String name, Integer index) {
        this.name = name;
        this.index = index;
    }
}
