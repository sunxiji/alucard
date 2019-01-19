package com.alucard.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author alucard
 * @Description
 * @Date Create in 8:52 2018/12/13
 */
@Data
@Entity
@Table(name ="t_product")
public class Product {

    /**
     * 自增主键id
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品编码
     */
    @Column(name = "product_number")
    private Long productNumber;

    /**
     * 供应商编码
     */
    @Column(name = "supplier_id")
    private Long supplierId;
}
