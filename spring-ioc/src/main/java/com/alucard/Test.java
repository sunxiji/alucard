package com.alucard;

import com.alucard.context.ClassPathXmlApplicationContext;
import com.alucard.entity.User;
import org.dom4j.DocumentException;

/**
 * @author alucard
 * @Description
 * @Date Create in 11:05 2018/10/27
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, DocumentException, IllegalAccessException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = (User) context.getBean("user1");
        User user2 = (User) context.getBean("user2");
        System.out.println("user1 = "+ user1);
        System.out.println("user2 = "+ user2);
    }
}
