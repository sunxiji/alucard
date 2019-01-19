package com.alucard.entity;

import lombok.Data;

/**
 * @author alucard
 * @Description
 * @Date Create in 8:52 2018/12/13
 */

@Data
public class Product {

    /**
     * 自增主键id
     */

    private Long id;

    /**
     * 商品名称
     */

    private String productName;

    /**
     * 商品编码(分表字段)
     */

    private Long productNumber;

    /**
     * 供应商编码(分库字段)
     */

    private Long supplierId;

}
