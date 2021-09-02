package com.fenyun.ws.manager.service.Impl.user;


import com.fenyun.ws.manager.BaseTest;
import com.fenyun.ws.manager.domain.user.User;
import com.fenyun.ws.manager.mapper.StudentMapper;
import com.fenyun.ws.manager.mapper.user.UserMapper;
import com.fenyun.ws.manager.shiro.BaseResponseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


public class IUserServiceImplTest3 extends BaseTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;

    @Value("${name.url}")
    private  String url;

    @Autowired
    BaseResponseUtil baseResponseUtil;

    @Test
    public void insertUser() {

        System.out.println( baseResponseUtil.getUrl());
        System.out.println(url);
    }


    private void updateUser1(User user) {

        user.setEmail("----------");
        userMapper.updateByPrimaryKey(user);
    }

    private synchronized void updateUser(List<Long> strings) {

        User user = new User();
        user.setEmail("------");
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", strings);
        userMapper.updateByExample(user, example);
    }


    public void get() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        Set<Thread> threadSet = new CopyOnWriteArraySet<>();
        // 并行执行
        list.parallelStream().forEach(integer -> {
            Thread thread = Thread.currentThread();
            // System.out.println(thread);
            // 统计并行执行list的线程
            threadSet.add(thread);
        });
        System.out.println("threadSet一共有" + threadSet.size() + "个线程");
        System.out.println("系统一个有" + Runtime.getRuntime().availableProcessors() + "个cpu");

    }
}
