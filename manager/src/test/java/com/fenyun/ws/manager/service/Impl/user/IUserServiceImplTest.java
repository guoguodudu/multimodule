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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserServiceImplTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser() {
        List<String> strings = Lists.newArrayList();
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        //  criteria.andEqualTo("name","");
        //criteria.andIn("name",strings);
        System.out.println(userMapper.selectAll().size());

        List<User> users = userMapper.selectAll();
    /*    for (int i = 0; i < 100000; i++) {
            User user=new User();
            user.setName(String.valueOf(i));
            users.add(user);
            userMapper.insert(user);
        }*/
        List<List<User>> userlist = Lists.partition(users, 5000);
        System.out.println(userlist.size());

        ExecutorService executorService = Executors.newFixedThreadPool(userlist.size());
        for (final List<User> userlists : userlist) {


            executorService.submit(() -> {

                    System.out.println(Thread.currentThread().getName() + "----" + userlists.size());
                for (final User user:userlists
                     ) {
                    updateUser1(user);
                    System.out.println(Thread.currentThread().getName() + "----" +user);
                }
             //   updateUser(userlists.stream().map(User::getId).collect(Collectors.toList()));
               // System.out.println(userlists.stream().map(User::getId).collect(Collectors.toList()));


            });
        }
        executorService.shutdown();

    }

    private  void  updateUser1(User user) {


        userMapper.updateByPrimaryKey(user);
    }

    private synchronized void  updateUser(List<Long> strings) {

        User user=new User();
        user.setEmail("------");
        Example example=new Example(User.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andIn("id",strings);
        userMapper.updateByExample(user,example);
    }
}
