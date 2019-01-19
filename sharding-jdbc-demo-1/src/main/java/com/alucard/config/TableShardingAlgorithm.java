package com.alucard.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;

import java.util.Collection;

public class TableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Long> {

	// sql 中关键字 匹配符为 =的时候，表的路由函数
	@Override
	public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<Long> shardingValue) {
		// availableTargetNames 是 两张表的的集合(t_order_0,t_order_1)
		// shardingValue 就是请求的值,也就是分片的值
		for (String tableName : availableTargetNames) {
            System.out.println("tableName:" + tableName + ",----" + shardingValue.getValue());
			if (tableName.endsWith(shardingValue.getValue() % 2 + "")) {
				return tableName;
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public Collection<String> doInSharding(Collection<String> availableTargetNames, ShardingValue<Long> shardingValue) {

		return null;
	}

	@Override
	public Collection<String> doBetweenSharding(Collection<String> availableTargetNames,
			ShardingValue<Long> shardingValue) {

		return null;
	}

}