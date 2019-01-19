package com.alucard.vo;

import java.io.Serializable;

/**
 * Created by zizhu.hzb(zizhu) on 2017-05-09.
 */
public class ApiVO implements Serializable {
    private String name;
    private String type;
    private String tableName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "ApiVO{" +
            "name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", tableName='" + tableName + '\'' +
            '}';
    }
}
