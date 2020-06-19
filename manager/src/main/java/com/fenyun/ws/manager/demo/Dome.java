package com.fenyun.ws.manager.demo;


import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fenyun.ws.manager.util.FadadaResult;
import com.fenyun.ws.manager.util.Kk;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.Synchronized;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Data
public class Dome implements Serializable {

    static  Hashtable<String, String> hashtable=new Hashtable();

    static  HashMap<String, String> hashtable2=new HashMap();

    static  List<String> arrayList=new Vector<>();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService=Executors.newFixedThreadPool(8);

        executorService.execute(()->{
            for (int i = 0; i <1000 ; i++) {
                arrayList.add(String.valueOf(i));
            }
        });
       // executorService.shutdown();
/*
        Thread t1=new Thread(()->{
            for (int i = 0; i <1000 ; i++) {
                arrayList.add(String.valueOf(i));
            }
        });

        Thread t2=new Thread(()->{
            for (int i = 0; i <1000 ; i++) {
                arrayList.add(String.valueOf(i));
            }
        });
        Thread t3=new Thread(()->{
            for (int i = 0; i <1000 ; i++) {
                arrayList.add(String.valueOf(i));
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();*/
        System.out.println(arrayList.size());
    }

    public static Boolean get( String kk){
        return StringUtils.isEmpty(kk);
    }
}
