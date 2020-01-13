package com.fenyun.ws.manager.service.Impl.user;


import com.fenyun.ws.manager.domain.user.User;
import com.fenyun.ws.manager.mapper.StudentMapper;
import com.fenyun.ws.manager.mapper.user.UserMapper;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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
        List<String>  strings= Lists.newArrayList();
        Example example=new Example(User.class);
        Example.Criteria criteria=example.createCriteria();
      //  criteria.andEqualTo("name","");
        criteria.andIn("name",strings);
        System.out.println(userMapper.deleteByExample(example));
    }
}
