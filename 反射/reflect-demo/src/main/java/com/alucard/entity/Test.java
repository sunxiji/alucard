package com.alucard.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:11 2018/10/13
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName("com.alucard.entity.UserEntity");
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);
        // 如果在别的类,想访问UserEntity,用下面那句才可以访问到私有的构造函数
        constructor.setAccessible(true);
        UserEntity userEntity = (UserEntity) constructor.newInstance("alucard");
        System.out.println(userEntity.username);
    }
}
