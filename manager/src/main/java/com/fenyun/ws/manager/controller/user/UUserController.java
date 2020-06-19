package com.fenyun.ws.manager.controller.user;

import com.fenyun.config.base.base.response.BaseController;
import com.fenyun.config.base.base.response.RestResponse;
import com.fenyun.ws.manager.domain.user.User;
import com.fenyun.ws.manager.request.IRequestLogin;
import com.fenyun.ws.manager.service.user.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UUserController extends BaseController {

    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/add")
    public RestResponse UserTest() {
        User user = new User();
        user.setLogin("123");
        user.setName("123");
        iUserService.insertUser(user);
        return insertResponse(iUserService.insertUser(user));
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.PATCH})
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
