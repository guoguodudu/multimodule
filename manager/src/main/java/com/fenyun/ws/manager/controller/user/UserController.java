package com.fenyun.ws.manager.controller.user;

import com.fenyun.config.base.base.response.BaseController;
import com.fenyun.config.base.base.response.RestResponse;
import com.fenyun.ws.manager.domain.user.User;
import com.fenyun.ws.manager.request.IRequestLogin;
import com.fenyun.ws.manager.service.user.IUserService;
import com.fenyun.ws.manager.thead.Executor.ThreadPoolDynamicTasks;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/use")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ThreadPoolDynamicTasks threadPoolDynamicTasks;

    @RequestMapping(value = "/test",method =RequestMethod.POST )
    public RestResponse getString(@RequestBody String mobile){
        System.out.println("string"+mobile);
        try {
            Thread.sleep(1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return successResponse("sdkfhsdj");
    }

    @RequestMapping(value = "/list2" )
    public RestResponse getSgtring(){

        for (int i = 0; i < 1000; i++) {
            threadPoolDynamicTasks.addTask(i);
        }

        return successResponse("123456");
    }

    @RequestMapping("/add")
    public RestResponse UserTest() {
        User user = new User();
        user.setLogin("123");
        user.setName("123");
        return insertResponse(iUserService.insertUser(user));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestResponse login(@RequestBody @Validated IRequestLogin iRequestLogin) {
        UsernamePasswordToken token = new UsernamePasswordToken(iRequestLogin.getLogin(), iRequestLogin.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return successResponse();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public RestResponse logout(@RequestBody @Validated IRequestLogin iRequestLogin) {
        UsernamePasswordToken token = new UsernamePasswordToken(iRequestLogin.getLogin(), iRequestLogin.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return successResponse();
    }
}
