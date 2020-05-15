package com.fenyun.ws.manager.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ddd {
    private final static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {

        System.out.println(LocalDateTime.parse("2020-04-23", df));


    }
}
