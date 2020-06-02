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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        List<User> userList = new Vector<>(users);
        Long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        users.stream().forEach(e -> {
//            updateUser1(e);
//        });


        userList.parallelStream().forEach(e -> {
            updateUser1(e);
        });

        Long end = System.currentTimeMillis();

        System.out.println("start-end" + (end - start));
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
