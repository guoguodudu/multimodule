package com.fenyun.ws.manager.controller.user;

import com.fenyun.ws.manager.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UUserController {

    @Autowired
    private IUserService iUserService;

    public static void main(String[] args) {

    }
}
