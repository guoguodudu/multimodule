package com.fenyun.ws.manager.controller;

import com.fenyun.config.base.base.annotation.BaseResult;
import com.fenyun.ws.manager.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu/")

public class StudentController {

    @Autowired
    private IStudentService iStudentService;


    @RequestMapping("add")
    @BaseResult
    public Object UserTest() {
        return "123";
    }

    @RequestMapping("userList")
    public String queryUserTest() {
        return "123";
    }
}
