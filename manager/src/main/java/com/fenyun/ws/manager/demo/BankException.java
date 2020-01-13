package com.fenyun.ws.manager.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.omg.CORBA.StringHolder;

@Data
@AllArgsConstructor
public class BankException extends Exception/*这里的继承不能少*/{
    private String code;
    private String msg;

}