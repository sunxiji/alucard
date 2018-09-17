package com.alucard.distributedlock.aspect;

/**
 * @Description: java类作用描述
 * @Author: gl
 * @CreateDate: 2018/6/25$ 14:53$
 * @Version: 1.0
 */
public class ExpressionRootObject {
    private final Object object;

    private final Object[] args;

    public ExpressionRootObject(Object object, Object[] args) {
        this.object = object;
        this.args = args;
    }

    public Object getObject() {
        return object;
    }

    public Object[] getArgs() {
        return args;
    }
}
