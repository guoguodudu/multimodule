package com.fenyun.ws.manager.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Builder()
@Accessors(chain = true)
@Data
@AllArgsConstructor
public class Demo2 {
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private String name;
    private String password;

    public Demo2() {

    }

    public static void main(String[] args) {

      /*  Demo2 demo2 = Demo2.builder().name("123").password("234").build();
       //demo2.

        Demo2 demo21=new Demo2();
        BeanUtils.copyProperties(demo2,demo21);
        demo21.setName("234234");

        System.out.println(demo2);

        System.out.println(demo21);*/

        DecimalFormat decimalFormat=new DecimalFormat("#.##");

        BigDecimal bigDecimal=new BigDecimal(12.55510);

        System.out.println(decimalFormat.format(bigDecimal));

        List<Map<String, Object>> maxBatchNumbersFinal=Lists.newArrayList();
        Map<String, Object> map= Maps.newHashMap();
        map.put("2","123213");
        map.put("3",34);
        Map<String, Object> map3= Maps.newHashMap();
       // map3.put("2","123");
        //map3.put("4",34.35555555);
        if(Objects.nonNull(map3.get("4"))) {
            System.out.println("333333333"+map3.get("4"));
        }
        System.out.println(String.format("%02d",3355));
        //maxBatchNumbersFinal.add(map);
        maxBatchNumbersFinal.add(map3);
      /*  Map<String, BigDecimal> map1=maxBatchNumbersFinal.stream().
                collect(Collectors.toMap(key->key.get("2").toString(), key->BigDecimal.valueOf(Double.valueOf(key.get("3").toString())),(oldVal, currVal) -> currVal));
*/
      //  System.out.println("111"+map1);

String kk="NAME_KK";
        System.out.println("11111111111111");
        System.out.println(lineToHump(kk));

        System.out.println(maxBatchNumbersFinal);
        List<String> strings= Lists.newArrayList();
        strings.add("123");
        strings.add("1234");
        strings.add("12345");
        List<String> strings2= Lists.newArrayList();
        strings2.add("123");
        strings2.add("1234");
        strings.removeAll(strings2);
        System.out.println(strings);
    /*    List<Demo> demos = Lists.newArrayList();


        List<Demo2> demo2List4 = Lists.newArrayList();

        long start1 = System.currentTimeMillis();
        demos.parallelStream().filter(Objects::nonNull).forEach(e -> {
            Demo2 demo2 = new Demo2();
            BeanUtils.copyProperties(e, demo2);
            demo2List4.add(demo2);
        });
        long end1 = System.currentTimeMillis();
        System.out.println("程序运行时间333："+(end1-start1)+"ms");

        List<Demo2> demo2List = Lists.newArrayList();
        long start = System.currentTimeMillis();
        demo2List = demos.stream().filter(Objects::nonNull).map(e -> {
                    Demo2 demo2 = new Demo2();
                    BeanUtils.copyProperties(e, demo2);
                    return demo2;
                }
        ).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间："+(end-start)+"ms");
*/


    }

    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
