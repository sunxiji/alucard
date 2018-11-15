package com.alucard.aspect;

import com.alucard.annotation.AluTransactional;
import com.alucard.service.TransactionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author alucard
 * @Description
 * @Date Create in 9:20 2018/11/15
 */
@Aspect
@Component
public class AopAluTransactional {

    @Autowired
    TransactionUtils transactionUtils;

    @Pointcut("@annotation(com.alucard.annotation.AluTransactional)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        AluTransactional aluTransactional = methodSignature.getMethod().getDeclaredAnnotation(AluTransactional.class);
        // 如果没有这个注解,直接放行,执行当前方法
        if (aluTransactional == null) {
            return pjp.proceed();
        }
        // 开启事务
        TransactionStatus begin = transactionUtils.begin();
        // 执行当前方法
        Object proceed = pjp.proceed();
        // 如果没有异常,直接提交事务
        transactionUtils.commit(begin);
        // 返回当前结果
        return proceed;
    }

    /**
     * 异常通知(当发生了异常才进来,需要将事务回滚)
     *
     * @param point
     */
    @AfterThrowing("pointcut()")
    public void afterThrowing(JoinPoint point) {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        AluTransactional aluTransactional = methodSignature.getMethod().getDeclaredAnnotation(AluTransactional.class);
        // 执行回滚
        if (null != aluTransactional) {
            transactionUtils.rollback(transactionUtils.getTransaction());
        }
        // 获取当前事务进行回滚
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
