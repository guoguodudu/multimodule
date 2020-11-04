package com.fenyun.ws.manager.controller.user;

import com.fenyun.ws.manager.service.user.IUserService;
import com.fenyun.ws.manager.thead.Executor.ThreadPoolDynamicTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/use")
public class UserController  {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ThreadPoolDynamicTasks threadPoolDynamicTasks;

}
