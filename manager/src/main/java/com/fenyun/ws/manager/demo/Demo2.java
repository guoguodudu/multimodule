package com.fenyun.ws.manager.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Demo2 {


    private final static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void automaticallyCloseResource() {
        File file = new File("./tmp.txt");
        try (FileInputStream inputStream = new FileInputStream(file)) {
            // use the inputStream to read a file
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {

        System.out.println(LocalDateTime.parse("2020-04-23", df));


    }
}
