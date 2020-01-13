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
import java.util.stream.Collectors;

@Data
public class Dome implements Serializable {

    private String k;
    private String ll;
    private Integer k1;
    private Integer k2;
    private Integer k3;



    public static void main(String[] args) {
        BigDecimal bigDecimal=BigDecimal.valueOf(-0.1);
        System.out.println(new BigDecimal(bigDecimal.toString()));
        System.out.println(bigDecimal.toString().charAt(0) == '-');
        System.out.println(Integer.parseInt(Integer.valueOf(-1).toString()));;
        System.out.println(Integer.parseInt("1"));
       // System.out.println(NumberUtil.equals(BigDecimal.valueOf(11.1), BigDecimal.valueOf(11.1)));
    }

    public static Boolean get( String kk){
        return StringUtils.isEmpty(kk);
    }
}
