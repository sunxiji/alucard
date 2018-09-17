package com.alucard.distributedlock.annotation;

import java.lang.annotation.*;

/**
 * @author alucard
 * @Description 注解分布式锁
 * @Date Create in 19:05 2018/9/17
 */
@Target(ElementType.METHOD) //字段注解
@Retention(RetentionPolicy.RUNTIME) //在运行期保留注解信息
@Documented     //在生成javac时显示该注解的信息
@Inherited      //标明MyAnnotation1注解可以被使用它的子类继承
public @interface DistributedLock {
    /**
     * 获取锁的超时时间
     */
    long acqireTimeout() default 1000L;

    /**
     * 拥有锁的超时时间
     */
    long timeout() default 1000L;

    /**
     * key
     */
    String key() default "";
}
