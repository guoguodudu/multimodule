package com.fenyun.ws.manager.demo;

import com.google.common.base.Splitter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ceshi {
    public static void main(String[] args) {

        List<String> strings= Arrays.asList("20190802-20190802","20200802-20190802");
        String string=strings.stream()
                .filter(Objects::nonNull).collect(Collectors.joining("-"));
        System.out.println(string);
        System.out.println(string);
        List<String> stringList= Arrays.asList(string.split("-"));
        System.out.println(stringList);
        System.out.println(LocalDate.parse(Collections.max(stringList),DateTimeFormatter.ofPattern("yyyyMMdd")).toString());
       // System.out.println(LocalDate.parse(Collections.max(stringList)));

    }
}
