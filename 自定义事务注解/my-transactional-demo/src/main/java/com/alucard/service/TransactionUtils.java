package com.alucard.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @author alucard
 * @Description
 * @Date Create in 10:03 2018/11/15
 */
@Service
@Scope("prototype")
@Slf4j
public class TransactionUtils {
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    private TransactionStatus transaction;

    public TransactionStatus begin(){
        //开启事务
        transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        log.info("开启事务...");
        return transaction;
    }

    public void commit(TransactionStatus transaction){
        dataSourceTransactionManager.commit(transaction);
        log.info("提交事务...");
    }

    public void rollback(TransactionStatus transaction){
        dataSourceTransactionManager.rollback(transaction);
        log.info("回滚事务...");
    }

    public TransactionStatus getTransaction() {
        return transaction;
    }
}
