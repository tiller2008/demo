package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        Factory<AService> factory=new AFactory();
        A a = new A();
        SpringApplication.run(DemoApplication.class, args);
        try {
//            Method method = AService.class.getInterfaces()[0].getMethod("save", AbstractBaseDomain.class);    // without issue
            Method method = AService.class.getMethod("save", AbstractBaseDomain.class); // issue: object is not an instance of declaring class
            Object result = method.invoke(factory.create("123"),a);
            System.out.println(result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
