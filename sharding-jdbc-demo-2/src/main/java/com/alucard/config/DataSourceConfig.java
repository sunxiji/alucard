package com.alucard.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 数据源相关配置信息
 *
 */
@Configuration
public class DataSourceConfig {
	public static final String DS_0 = "ds_0";
	public static final String DS_1 = "ds_1";
	private List<String> list = Arrays.asList("t_product_0", "t_product_1");

	@Value("${spring.jdbc.db0.className}")
	private String className;
	@Value("${spring.jdbc.db0.url}")
	private String url;
	@Value("${spring.jdbc.db0.username}")
	private String username;
	@Value("${spring.jdbc.db0.password}")
	private String password;

	@Bean
	public IdGenerator getIdGenerator() {
		return new CommonSelfIdGenerator();
	}

	@Bean
	public DataSource getDataSource() {
		return buildDataSource();
	}

	private DataSource buildDataSource() {
		//设置分库映射
		Map<String, DataSource> dataSourceMap = new HashMap<>(2);
		//添加两个数据库ds_0,ds_1到map里
		dataSourceMap.put("ds_0", createDataSource(DS_0));
		dataSourceMap.put("ds_1", createDataSource(DS_1));

		// 设置数据源规则,第一个参数是数据源集合的map,第二个参数是设置默认db为ds_0
		DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap, DS_0);

		//设置分表映射，将t_product_0和t_product_1两个实际的表映射到t_product逻辑表
		//0和1两个表是真实的表，t_product是个虚拟不存在的表，只是供使用。如查询所有数据就是select * from t_product就能查完0和1表的
        // 设置分表规则
		TableRule orderTableRule = TableRule.builder("t_product")
				.actualTables(list)
				.dataSourceRule(dataSourceRule)
				.build();

		//具体分库分表策略，按什么规则来分
        // 设置分表规则
		ShardingRule shardingRule = ShardingRule.builder()
                // 设置dataSourceRule
				.dataSourceRule(dataSourceRule)
                // 设置tableRules,这里可以设置多个表的规则
				.tableRules(Arrays.asList(orderTableRule))
				// 分库的策略,这里走自定义分库的逻辑
				.databaseShardingStrategy(new DatabaseShardingStrategy("supplier_id", new DatabaseShardingAlgorithm()))
                // 分表的侧率,这里走自定义分表的逻辑
				.tableShardingStrategy(new TableShardingStrategy("product_number", new TableShardingAlgorithm())).build();
        // 分片工厂创建数据源
		DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);

		return dataSource;

	}

    /**
     * 创建DS
     * @param dataSourceName
     * @return DataSource
     */
	private DataSource createDataSource(String dataSourceName) {
		// 使用druid连接数据库
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(className);
		druidDataSource.setUrl(String.format(url, dataSourceName));
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		return druidDataSource;
	}
}