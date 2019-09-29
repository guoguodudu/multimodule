package com.fenyun.ws.manager.service;

import com.fenyun.ws.manager.domain.Student;

import java.util.List;

public interface IStudentService {
    int insertStudent();

    List<Student> queryStudent();

    void queryStudentRedis();

}
