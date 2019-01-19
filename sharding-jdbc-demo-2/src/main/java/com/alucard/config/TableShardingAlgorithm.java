package com.alucard.config;

import com.alucard.utils.ShardingUtils;
import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;

import java.util.Collection;

/**
 * @author alucard
 * @Description 具体需要分表的策略, 这里是product_number 的策略
 * @Date Create in 16:53 2018/12/12
 */
public class TableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Long> {

    /**
     * 对于分片字段的等值操作 都走这个方法。(包括 插入 更新)
     *
     * @param availableTableNames 所有表集合
     * @param shardingValue       具体的product_number的值
     * @return
     */
    @Override
    public String doEqualSharding(final Collection<String> availableTableNames, final ShardingValue<Long> shardingValue) {
        return ShardingUtils.doEqualShardingBussiness(availableTableNames, shardingValue);
    }


    /**
     * 对于分片字段的in操作，都走这个方法。
     *
     * @param availableTableNames 所有表集合
     * @param shardingValue       具体的product_number的值
     * @return
     */
    @Override
    public Collection<String> doInSharding(final Collection<String> availableTableNames, final ShardingValue<Long> shardingValue) {
        return ShardingUtils.doInShardingBussiness(availableTableNames, shardingValue);
    }

    /**
     * 对于分片字段的between操作都走这个方法。
     *
     * @param availableTableNames 所有表集合
     * @param shardingValue       具体的product_number的值
     * @return
     */
    @Override
    public Collection<String> doBetweenSharding(final Collection<String> availableTableNames, final ShardingValue<Long> shardingValue) {
        return ShardingUtils.doBetweenSharding(availableTableNames, shardingValue);
    }

}
