package com.fenyun.ws.manager.demo;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecoratorPattern {
    public static void main(String[] args) {
        Component p = new ConcreteComponent();
        p.operation();
        System.out.println("---------------------------------");
        Component d = new ConcreteDecorator(p);
        d.operation();

       // Component d3 = new ConcreteDecorator3(d);

       // d3.operation();
    }
}
//抽象构件角色
interface Component {
    public void operation();
}
//具体构件角色
class ConcreteComponent implements Component {
    public ConcreteComponent() {
        System.out.println("创建具体构件角色");
    }
    public void operation() {
        System.out.println("调用具体构件角色的方法operation()");
    }
}
//抽象装饰角色
class Decorator implements Component {
    private Component component;
    public Decorator(Component component) {
        this.component = component;
    }
    public void operation() {
        component.operation();
    }
}
//具体装饰角色
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }
    public void operation() {
        super.operation();
        addedFunction();
    }
    List  list=new ArrayList();
    public void addedFunction() {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}

//具体装饰角色
class ConcreteDecorator3 {


    ConcreteDecorator3(){
    }
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
          Method[] method=ConcreteDecorator3.class.getMethods();

        Arrays.asList(method).stream().forEach(System.out::println);

        Constructor constructor=ConcreteDecorator3.class.getEnclosingConstructor();
        constructor.setAccessible(true);
        ConcreteDecorator3 concreteDecorator3= (ConcreteDecorator3) constructor.newInstance();
        System.out.println(concreteDecorator3);
    }

}