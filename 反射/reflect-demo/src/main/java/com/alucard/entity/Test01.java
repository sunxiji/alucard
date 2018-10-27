package com.alucard.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alucard
 * @Description
 * @Date Create in 9:36 2018/10/27
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.new 方式创建对象
        System.out.println("//new 方式创建对象");
        User user = new User();
        user.setId(13);
        user.setName("alucard");
        System.out.println(user.toString());
        System.out.println("-------------------------------");
        //2.使用java的反射机制创建对象Class.forName("类的完整路径");
        System.out.println("//使用java的反射机制创建对象Class.forName(\"类的完整路径\")");
        Class<?> forName = Class.forName("com.alucard.entity.User");
        //3.使用默认无参构造函数创建对象forName.newInstatnce(),使用java的反射机制创建对象
        User classUser = (User) forName.newInstance();
        classUser.setId(22);
        System.out.println(classUser);
        System.out.println("-------------------------------");
        //创建带有参的构造函数
        System.out.println("//创建带有参的构造函数");
        Constructor<?> constructor = forName.getConstructor(Integer.class, String.class);
        User alucard = (User) constructor.newInstance(12, "alucard");
        System.out.println(alucard);

    }
}
