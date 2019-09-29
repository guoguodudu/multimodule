package com.fenyun.ws.manager.mapper;

import com.fenyun.ws.manager.domain.Student;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface StudentMapper extends Mapper<Student> {
}