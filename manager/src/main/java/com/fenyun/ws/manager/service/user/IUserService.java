package com.fenyun.ws.manager.service.user;


import com.fenyun.ws.manager.domain.user.User;

public interface IUserService {

    int insertUser(User user);

    public User getUserByLogin(String login);
}
