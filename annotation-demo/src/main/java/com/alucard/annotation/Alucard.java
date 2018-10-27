package com.alucard.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author alucard
 * @Description 自定义注解
 * @Date Create in 11:45 2018/10/27
 */
//@Target 访问权限,可以在方法上,类上.属性上使用
@Target(value = {ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
//@Retention的作用是定义被它所注解的注解保留多久
//SOURCE
//被编译器忽略
//
//CLASS
//注解将会被保留在Class文件中，但在运行时并不会被VM保留。这是默认行为，所有没有用Retention注解的注解，都会采用这种策略。
//
//RUNTIME
//保留至运行时。所以我们可以通过反射去获取注解信息。
@Retention(RetentionPolicy.RUNTIME)
public @interface Alucard {
    int beanId() default 0;

    String className() default "";

    String[] arr();
}
