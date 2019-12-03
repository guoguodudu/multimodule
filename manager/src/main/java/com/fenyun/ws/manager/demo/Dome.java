package com.fenyun.ws.manager.demo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fenyun.ws.manager.util.FadadaResult;
import com.fenyun.ws.manager.util.Kk;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class Dome implements Serializable {

    private String k;
    private String ll;
    private Integer k1;
    private Integer k2;
    private Integer k3;



    public static void main(String[] args) {

        List<Dome> domes= Lists.newArrayList();

        Dome dome=new Dome();
        dome.setK("11");
        dome.setLl("11");
        dome.setK1(1);
        dome.setK2(1);
        dome.setK3(1);
        domes.add(dome);

        Dome dome2=new Dome();
        dome2.setK("11");
        dome2.setLl("11");
        dome2.setK1(2);
        dome2.setK2(2);
        dome2.setK3(2);
        domes.add(dome2);


        Dome dome3=new Dome();
        dome3.setK("22");
        dome3.setLl("22");
        dome3.setK1(1);
        dome3.setK2(1);
        dome3.setK3(1);
        domes.add(dome3);



        Map<String, Integer> studentScoreMap2 = new HashMap<>();
        domes.forEach(studentScore -> studentScoreMap2.merge(
                studentScore.getK(),
                studentScore.getK1(),
                Integer::sum));

        System.out.println(studentScoreMap2);






     /*   Map map=new ConcurrentHashMap();

        List list =new ArrayList();
        Kk kk=new Kk();
        kk.setPp("12323");
        kk.setKp("45");
        dome.setKk(kk);
        object.put("data",dome);
        System.out.println(object);
        FadadaResult<Dome> fadadaResult= JSON.parseObject(object.toString(),new TypeReference<FadadaResult<Dome>>(){});
        System.out.println(fadadaResult.getData());*/
    }
}
