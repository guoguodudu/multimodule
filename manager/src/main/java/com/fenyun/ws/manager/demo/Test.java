package com.fenyun.ws.manager.demo;

import com.fenyun.ws.manager.annotation.ValidateService;

public class Test {
    public static void main(String[] args){
        System.out.println(Test.main22(args));
    }

    public static String main22(String[] args) {
        User user=new User("qweqweqwe", "xdemo.org", "qweqwewqe");

        user=new User("sdfsdafdsaf",null,"12312321","123");
        try {
            ValidateService.valid(user);
        }  catch (BankException e) {
            return e.getCode()+e.getMsg();
            //  e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return "1";
    }
}
