package com.alucard.controller;

import com.alucard.entity.Product;
import com.alucard.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @author alucard
 * @Description
 * @Date Create in 19:57 2018/12/13
 */
@RequestMapping("product")
@RestController
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @GetMapping("/insertProduct")
    public String insertProduct() {

        // 随机循环50次,
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            // 0-99
            int num1 = random.nextInt(100);
            int num2 = random.nextInt(100);
            Product p = new Product();
            p.setProductName("iphone" + i);
            p.setProductNumber((long)num1);
            p.setSupplierId((long)num2);
            productMapper.insertSelective(p);
        }
        // product_number 偶 supplier_id 偶 存入ds_0库的t_product_0表
        // product_number 奇 supplier_id 偶 存入ds_0库的t_product_1表
        // product_number 偶 supplier_id 奇 存入ds_1库的t_product_0表
        // product_number 奇 supplier_id 奇 存入ds_1库的t_product_1表
        return "success";
    }

    /**
     * 查询所有商品
     *
     * @return
     */
    @GetMapping("/queryAll")
    public Object queryAll() {
        //查询出来的数据,是按照一张表一张表的顺序展示
        List<Product> all = productMapper.selectList();
        return all;
    }
}
