package com.fenyun.ws.manager.service.Impl;

import com.fenyun.ws.manager.domain.Student;
import com.fenyun.ws.manager.mapper.StudentMapper;
import com.fenyun.ws.manager.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@Service
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public int insertStudent() {

        log.info("methed=insertStudent");


        Student student=new Student();;
         student=new Student();
        student.setId(null);
        student.setString(null);
        student.setName(null);
        student.setAddress("3");
        studentMapper.insert(student);

        int i = 0;
        return i;
    }

    @Override
    public List<Student> queryStudent() {

        log.info("methed=queryStudent");


        return studentMapper.selectAll();
    }

    @Override
    public void queryStudentRedis() {
    }
}
