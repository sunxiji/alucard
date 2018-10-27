package com.alucard.context;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author alucard
 * @Description
 * @Date Create in 10:42 2018/10/27
 */
public class ClassPathXmlApplicationContext {
    private static String PATH;
    private static String ID;
    private static String CLASS;
    private static String NAME;
    private static String VALUE;

    public void init() {
        ID = "id";
        CLASS = "class";
        NAME = "name";
        VALUE = "value";
    }

    public ClassPathXmlApplicationContext(String path) {
        init();
        //获取spring读取文件名称
        this.PATH = path;
    }

    public Object getBean(String beanId) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //Dom4J+java的反射机制
        //1.解析xml
        if (StringUtils.isEmpty(beanId)) {
            return null;
        }

        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(this.getClass().getClassLoader().getResource(PATH));
        //根节点
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            String id = element.attributeValue(ID);
            if (!beanId.equals(id)) {
                //结束本次循环
                continue;
            }
            //2.使用beanId查找到对应xml节点,获得class节点属性
            //从配置文件中获取bean
            String attrClass = element.attributeValue(CLASS);
            //3.使用java反射机制初始化类
            Class<?> forName = Class.forName(attrClass);
            Object newInstatnce = forName.newInstance();
            //4.获取属性
            List<Element> sonElements = element.elements();
            for (Element sonElement : sonElements) {
                //获取配置文件属性名称
                String attrField = sonElement.attributeValue(NAME);
                //获取属性的value
                String attrValue = sonElement.attributeValue(VALUE);
                //通过反射获取到该属性
                Field declaredField = forName.getDeclaredField(attrField);
                //允许java反射操作私有属性
                declaredField.setAccessible(true);
                //给私有属性赋值
                declaredField.set(newInstatnce, attrValue);
            }
            return newInstatnce;
        }
        return null;

    }
}
