package com.alucard.config;

import com.alucard.utils.ShardingUtils;
import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;

import java.util.Collection;

/**
 * @author alucard
 * @Description 具体需要分库的策略, 这里是supplier_id 的策略
 * @Date Create in 16:53 2018/12/12
 */
public class DatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Long> {
    /**
     * 对于分片字段的等值操作 都走这个方法。
     *
     * @param availableDatabaseNames 所有库集合
     * @param shardingValue          具体的supplier_id的值
     * @return
     */
    @Override
    public String doEqualSharding(Collection<String> availableDatabaseNames, ShardingValue<Long> shardingValue) {

        return ShardingUtils.doEqualShardingBussiness(availableDatabaseNames, shardingValue);
    }

    /**
     * 对于分片字段的in操作，都走这个方法。
     *
     * @param availableDatabaseNames 所有库集合
     * @param shardingValue          具体的supplier_id的值
     * @return
     */
    @Override
    public Collection<String> doInSharding(Collection<String> availableDatabaseNames, ShardingValue<Long> shardingValue) {
        return ShardingUtils.doInShardingBussiness(availableDatabaseNames, shardingValue);
    }

    /**
     * 对于分片字段的between操作，都走这个方法。
     *
     * @param availableDatabaseNames 所有库集合
     * @param shardingValue          具体的supplier_id的值
     * @return
     */
    @Override
    public Collection<String> doBetweenSharding(Collection<String> availableDatabaseNames,
                                                ShardingValue<Long> shardingValue) {
        return ShardingUtils.doBetweenSharding(availableDatabaseNames, shardingValue);
    }


}