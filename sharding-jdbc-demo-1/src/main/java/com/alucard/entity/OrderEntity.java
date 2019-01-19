package com.alucard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author alucard
 * @Description
 * @Date Create in 15:43 2018/12/12
 */
@Data
@Entity
@Table(name ="t_order")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "user_id")
    private Long userId;

}
