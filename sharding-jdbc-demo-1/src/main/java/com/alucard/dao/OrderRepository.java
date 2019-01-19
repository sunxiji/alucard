package com.alucard.dao;

import com.alucard.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
	@Query(value = "SELECT order_id ,user_id  FROM t_order  where order_id in (?1);", nativeQuery = true)
	 List<OrderEntity> findExpiredOrderState(List<String> bpIds);

	@Query(value = "SELECT order_id ,user_id  FROM t_order  where user_id=:userId ", nativeQuery = true)
	 List<OrderEntity> findByUserId(@Param("userId") Long userId);
}