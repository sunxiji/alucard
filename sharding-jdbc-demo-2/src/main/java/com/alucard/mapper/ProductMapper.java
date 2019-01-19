package com.alucard.mapper;

import com.alucard.entity.Product;

import java.util.List;

/**
 * jpa
 * @author alucard
 * @Description
 * @Date Create in 19:56 2018/12/13
 */
public interface ProductMapper {

    int insertSelective(Product product);

    List<Product> selectList();
}
