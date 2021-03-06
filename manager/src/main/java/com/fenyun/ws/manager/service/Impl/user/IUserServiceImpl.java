package com.fenyun.ws.manager.service.Impl.user;

import com.fenyun.ws.manager.domain.user.User;
import com.fenyun.ws.manager.mapper.user.RoleMapper;
import com.fenyun.ws.manager.mapper.user.UserMapper;
import com.fenyun.ws.manager.service.user.IUserService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Slf4j
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

   // @Autowired
   // private BaseRoleMapper baseRoleMapper;

    @Override
    public int insertUser(User user) {

        List list= Lists.newArrayList();
        log.info("method=insertUser,user=【{}】",user);

        System.out.println(userMapper.findByUserName("123"));

        System.out.println(roleMapper.selectAll());

       // List<Role> role=roleMapper.findByUserRole2(1L);

        //System.out.println(roleMapper.findByUserRole2(1L));


       // System.out.println(baseRoleMapper.findByUserRole2(1L));

        return userMapper.insert(user);
    }

    @Override
    public User getUserByLogin(String login) {
        log.info("method=getUserByLogin, login={}", login);
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("login", login).andEqualTo("isDelete",false);
        return userMapper.selectOneByExample(example);
    }

}
