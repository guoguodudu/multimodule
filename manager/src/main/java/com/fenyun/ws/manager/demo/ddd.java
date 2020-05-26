package com.fenyun.ws.manager.demo;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ddd {
    //private final static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @NotNull public static void someMethod( String  someParameter) {
       // someParameter.equals("");
        System.out.println("123");
    }

    public static void main(String[] args) {

       // System.out.println(LocalDateTime.parse("2020-04-23", df));

        ddd.someMethod(null);

    }
}
