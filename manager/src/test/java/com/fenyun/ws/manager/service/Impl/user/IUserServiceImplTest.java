package com.fenyun.ws.manager.service.Impl.user;


import com.fenyun.ws.manager.domain.user.User;
import com.fenyun.ws.manager.mapper.StudentMapper;
import com.fenyun.ws.manager.mapper.user.UserMapper;
import com.google.common.collect.Lists;
import org.apache.commons.collections.ListUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        //criteria.andIn("name",strings);
        System.out.println(userMapper.selectAll().size());

        List<User> users=userMapper.selectAll();
     /*   for (int i = 0; i < 100000; i++) {
            User user=new User();
            user.setName(String.valueOf(i));
            users.add(user);
            userMapper.insert(user);
        }*/
        List<List<User>> userlist = Lists.partition(users, 5000);
        System.out.println(userlist.size());

        ExecutorService executorService=Executors.newFixedThreadPool(1);
        for (int i = 0; i < 1; i++) {
            int finalI = i;
            executorService.execute(()->{

                System.out.println(userlist.get(finalI).size());
                for (User user:
                userlist.get(finalI)) {
                    System.out.println(Thread.currentThread().getName()+"---------"+finalI);
                    System.out.println(user);
                    updateUser(user);
                }

            });
        }
       // executorService.shutdown();

    }
    private void updateUser(User user){
        userMapper.updateByPrimaryKey(user);
    }
}
