package com.fenyun.ws.manager.fenyun;

import cn.hutool.json.JSONUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class UpdatePassword {

    public final static String HASH_ALGORITHM_NAME = "MD5"; 	//shiro加密算法
    public final static int HASH_ITERATIONS = 2;

    int kk;

    public static void main(String[] args) {

        String userName="EF863";
        String password="12345";

        String pwd = new SimpleHash(
                HASH_ALGORITHM_NAME,
                password,
                ByteSource.Util.bytes(userName+"everest"),
                HASH_ITERATIONS
        ).toString();

        System.out.println(pwd);
    }
}
