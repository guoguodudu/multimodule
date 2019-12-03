package com.fenyun.config.base.base.enums;

public enum EmErrorMsg {

    FAIL("系统异常", Integer.valueOf(0)),
    SUCCESS("返回成功", Integer.valueOf(1)),
    SUCCESSSLECT("查询成功", Integer.valueOf(2)),
    SUCCESSUPDATE("更新成功", Integer.valueOf(3)),
    SUCCESSINSERT("插入成功", Integer.valueOf(4)),
    SUCCESSDELETE("删除成功", Integer.valueOf(5)),
    SUCCESSLOGIN("登录成功", Integer.valueOf(6)),
    SUCCESSLOGOUT("退出登录成功", Integer.valueOf(7)),

    FAILSLECT("查询失败", Integer.valueOf(102)),
    FAILUPDATE("更新失败", Integer.valueOf(103)),
    FAILINSERT("插入失败", Integer.valueOf(104)),
    FAILDELETE("删除失败", Integer.valueOf(105)),


    FAILDATABASE("数据库异常", Integer.valueOf(200)),
    FAILPARAM("参数失败", Integer.valueOf(201)),
    FAILPHONECODE("验证码错误", Integer.valueOf(101)),
    FAILLOGIN("用户名或密码错误", Integer.valueOf(102)),
    FAILLOGOUT("推出登陆失败", Integer.valueOf(107)),
    FAILNOTLOGIN("用户未登录/登录过期", Integer.valueOf(103)),
    FAILACCESS("用户没有权限", Integer.valueOf(104)),
    FAILNOTLOGINNAME("用户名重复", Integer.valueOf(105)),
    FAILNOTLOGINNAMELOCK("用户名重复", Integer.valueOf(105)),
    FAILLOGINNAMENOTEXEIT("用户名不存在", Integer.valueOf(102));

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
