package com.alucard;

import com.alucard.annotation.Property;
import com.alucard.annotation.Table;

import java.lang.reflect.Field;

/**
 * @author alucard
 * @Description
 * @Date Create in 12:40 2018/10/27
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("//模拟mybatis拼接sql语句");
        Class<?> forName = Class.forName("com.alucard.entity.Student");

        //获取所有当前的方法
        Field[] declaredFields = forName.getDeclaredFields();
        StringBuffer sf = new StringBuffer();
        sf.append(" select ");
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            Property property = field.getDeclaredAnnotation(Property.class);
            sf.append(property.name());
            if (i<declaredFields.length-1){
                sf.append(",");
            }
        }
        //获取类上注解参数
        Table declaredAnnotation = forName.getDeclaredAnnotation(Table.class);
        sf.append(" from ").append(declaredAnnotation.value());
        System.out.println(sf.toString());
    }
}
