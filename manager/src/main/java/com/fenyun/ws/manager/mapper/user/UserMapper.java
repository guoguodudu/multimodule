package com.fenyun.ws.manager.mapper.user;

import com.fenyun.ws.manager.domain.user.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    User findByUserName(String UserLogin);
}