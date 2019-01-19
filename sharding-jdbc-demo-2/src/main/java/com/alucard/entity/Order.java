package com.alucard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author alucard
 * @Description
 * @Date Create in 15:43 2018/12/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long orderId;

    private Long userId;

}
