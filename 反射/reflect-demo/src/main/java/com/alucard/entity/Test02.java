package com.alucard.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author alucard
 * @Description
 * @Date Create in 10:11 2018/10/27
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1.使用java的反射机制 获取类的所有属性 方法 并且为私有属性赋值
        Class<?> forName = Class.forName("com.alucard.entity.User");

        //2.获取到当前类的所有属性
        Field[] declaredFields = forName.getDeclaredFields();
        System.out.println("//获取到当前类的所有属性");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        System.out.println("---------------------------");
        //3.获取当前类的所有的方法
        Method[] declaredMethods = forName.getDeclaredMethods();
        System.out.println("//获取当前类的所有的方法");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        System.out.println("------------------------");
        //4.使用java的反射机制给私有属性赋值
        System.out.println("//使用java的反射机制给私有属性赋值");
        Object newInstance = forName.newInstance();
        Field fieldId = forName.getDeclaredField("id");
        // 允许反射操作私有属性
        fieldId.setAccessible(true);
        fieldId.set(newInstance,13);

        Field fieldName = forName.getDeclaredField("name");
        fieldName.setAccessible(true);
        fieldName.set(newInstance,"alucard");
        User user = (User) newInstance;
        System.out.println(user);
    }
}
