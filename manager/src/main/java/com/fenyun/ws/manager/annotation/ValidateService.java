package com.fenyun.ws.manager.annotation;

import com.fenyun.ws.manager.demo.BankException;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

public class ValidateService {
    private static DV dv;

    public ValidateService() {
        super();
    }

    //解析的入口
    public static void valid(Object object) throws Exception{
        //获取object的类型
        Class<? extends Object> clazz=object.getClass();
        //获取该类型声明的成员
        Field[] fields=clazz.getDeclaredFields();
        //遍历属性
        for(Field field:fields){
            //对于private私有化的成员变量，通过setAccessible来修改器访问权限
            field.setAccessible(true);
            validate(field,object);
            //重新设置会私有权限
            field.setAccessible(false);
        }
    }


    public static void validate(Field field,Object object) throws Exception{

        String description;
        Object value;

        //获取对象的成员的注解信息
        dv=field.getAnnotation(DV.class);
        value=field.get(object);

        if(dv==null)return;

        description=dv.description().equals("")?field.getName():dv.description();

        /*************注解解析工作开始******************/
        System.out.println(field.getGenericType());
        if(field.getType()== String.class) {
            System.out.println(field.getGenericType());
            if (!dv.nullable()) {
                if (value == null || StringUtils.isEmpty(value.toString())) {
                    throw new BankException("123", description + "不能为空");
                    //throw new Exception(description+"不能为空");
                }
            }
        }
        if(field.getType()== Integer.class) {
            System.out.println(field.getGenericType());
            if (!dv.nullable()) {
                if (value == null ) {
                    throw new BankException("123", description + "不能为空");
                    //throw new Exception(description+"不能为空");
                }
            }
        }

        /*************注解解析工作结束******************/
    }
}
