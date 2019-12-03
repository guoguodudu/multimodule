package com.fenyun.ws.manager.excel.java8;

import com.google.common.collect.Lists;
import com.rabbitmq.tools.json.JSONUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
public class Demo {
    private String name;
    private Integer sort;
    private Integer age;

    public static void getnamell(String ...args){
        List<String> strings= Arrays.asList(args);
        System.out.println(strings);
    }
    public static void main(String[] args) {

        List<Demo> demos = Lists.newArrayList();
        Demo demo = new Demo();
        demo.setAge(1);
        demo.setSort(1);
        demo.setName("1");
        demos.add(demo);

        Demo demo2 = new Demo();
        demo2.setAge(1);
        demo2.setSort(2);
        demo2.setName("2");
        demos.add(demo2);

        Demo demo4 = new Demo();
        demo4.setAge(2);
        demo4.setSort(3);
        demo4.setSort(3);
        demo4.setName("3");
        demos.add(demo4);

        Demo demo3 = new Demo();
        demo3.setAge(2);
        demo3.setSort(3);
        demo3.setSort(3);
        demo3.setName("3");
        demos.add(demo3);

        BigDecimal bigDecimal = BigDecimal.valueOf(0.554999);
        System.out.println(bigDecimal.setScale(2,4));

   /*     BigDecimal bigDecimal = BigDecimal.valueOf(11.2);
        System.out.println(bigDecimal.multiply(BigDecimal.valueOf(0.04)).setScale(2, 4));

        Map<Integer, List<Demo>> map = demos.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(Demo::getAge));
        map.forEach((integer, demos1) -> {
            System.out.println(demos1);
        });
        System.out.println(map);


        String sddd = "3427779843".replaceAll("(\\d{1,3})(?=(\\d{3})+(?:$|\\.))", "$1,");
        System.out.println(sddd);*/


   demos.stream().filter(Objects::nonNull).forEach(demo1 -> System.out.println(demo1));

   Map<String,Demo> map=demos.stream().collect(Collectors.toMap(Demo::getName, Function.identity(),(key1,key2)->key2));
        System.out.println(map.get("2"));
        Demo.getnamell();

    }
}
