package com.fenyun.ws.manager.service.Impl.user;


import com.fenyun.ws.manager.mapper.StudentMapper;
import com.fenyun.ws.manager.mapper.user.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserServiceImplTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;
    @Test
    public void insertUser() {
        System.out.println(userMapper.getMapMax());
    }
}
