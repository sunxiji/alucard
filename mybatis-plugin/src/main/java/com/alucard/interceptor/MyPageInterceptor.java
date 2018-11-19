package com.alucard.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;


@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class MyPageInterceptor implements Interceptor {

    private int pageSize; //每页显示个数

    private int currPage; //当前页

    private String dbType;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //获取StatementHandler 以及包装类
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject MetaObjectHandler = SystemMetaObject.forObject(statementHandler);
        //分离代理对象链
        while (MetaObjectHandler.hasGetter("h")) {
            Object obj = MetaObjectHandler.getValue("h");
            MetaObjectHandler = SystemMetaObject.forObject(obj);
        }
        while (MetaObjectHandler.hasGetter("target")) {
            Object obj = MetaObjectHandler.getValue("target");
            MetaObjectHandler = SystemMetaObject.forObject(obj);
        }
        //获取查询接口映射的相关信息
        MappedStatement mappedStatement = (MappedStatement) MetaObjectHandler.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();

        //拦截以.ByPage结尾的请求，统一实现分页功能
        if (mapId.matches(".+ByPage$")) {
            Map<String, Object> paraObject = (Map<String, Object>) statementHandler.getBoundSql().getParameterObject();
            currPage = (Integer) paraObject.get("currPage");
            pageSize = (Integer) paraObject.get("pageSize");

            //构建分页功能的sql语句并赋值
            String sql = statementHandler.getBoundSql().getSql();
            String limitSql;
            sql = sql.trim();
            limitSql = sql + " limit " + (currPage - 1) * pageSize + "," + pageSize;
            MetaObjectHandler.setValue("delegate.boundSql.sql", limitSql);
        }
        //调用原对象的方法
        return invocation.proceed();
    }


    //假如我们只要拦截StatementHandler对象，那么应该这么做
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    //设置代理对象的参数
    @Override
    public void setProperties(Properties properties) {
        //如果项目中分页的pageSizeXMLConfigBuilder是统一的，也可以在这里统一配置和获取，这样就不用每次请求都传递pageSize参数了。参数是在配置拦截器时配置的。
        String limit1 = properties.getProperty("limit", "10");
        this.pageSize = Integer.valueOf(limit1);
        this.dbType = properties.getProperty("dbType", "mysql");
    }
}