package com.alucard.utils;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @author alucard
 * @Description
 * @Date Create in 8:32 2018/12/27
 */
public class ShardingUtils {

    public static String doEqualShardingBussiness(Collection<String> tableOrDatabase, ShardingValue<Long> shardingValue) {
        for (String each : tableOrDatabase) {
            // value对2取余
            if (each.endsWith(shardingValue.getValue() % 2 + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    public static Collection<String> doInShardingBussiness(Collection<String> tableOrDatabase, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableOrDatabase.size());
        for (Long value : shardingValue.getValues()) {
            for (String tableOrDatabaseName : tableOrDatabase) {
                // value对2取余
                if (tableOrDatabaseName.endsWith(value % 2 + "")) {
                    result.add(tableOrDatabaseName);
                }
            }
        }
        return result;
    }

    public static Collection<String> doBetweenSharding(Collection<String> tableOrDatabase,
                                                       ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableOrDatabase.size());
        Range<Long> range = shardingValue.getValueRange();
        for (Long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            // value对2取余
            for (String each : tableOrDatabase) {
                if (each.endsWith(i % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
