package com.alucard.rabbitmq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:58 2018/9/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = -1L;

    private String id;

    private String name;

    private String messageId;

}
