package com.xlk.config;
import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;



@Configuration
@MapperScan("com.xlk.dao")
public class DataSourceConfig {

	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
	
    /** 驱动名称*/
    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    /** 数据库连接url*/
    @Value("${spring.datasource.url}")
    private String url;
    /** 数据库用户名*/
    @Value("${spring.datasource.username}")
    private String userName;
    /** 数据库密码*/
    @Value("${spring.datasource.password}")
    private String password;
 
    /**数据库连接池初始化大小*/
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
 
    /** 数据库连接池最小最小连接数*/
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
 
    /** 数据库连接池最大连接数*/
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
 
    /** 获取连接等待超时的时间*/
    @Value("${spring.datasource.maxWait}")
    private long maxWait;
 
    /** 多久检测一次*/
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
 
    /**连接在池中最小生存的时间*/
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
 
    /**测试连接是否有效的sql*/
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
 
    /**申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，检测连接是否有效*/
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
 
    /** 申请连接时,检测连接是否有效*/
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
 
    /**归还连接时,检测连接是否有效*/
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
 
    /*** PSCache大小*/
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
   
    @Bean
    @Primary
    public  DataSource dataSource() {
    	DruidDataSource  druidDataSource  = new DruidDataSource();
    	druidDataSource.setUrl(url);
    	druidDataSource.setUsername(userName);
    	druidDataSource.setPassword(password);
    	druidDataSource.setInitialSize(initialSize);
    	druidDataSource.setMinIdle(minIdle);
    	druidDataSource.setMaxActive(maxActive);
    	druidDataSource.setMaxWait(maxWait);
    	druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
    	druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    	druidDataSource.setValidationQuery(validationQuery);
    	druidDataSource.setTestWhileIdle(testWhileIdle);
    	druidDataSource.setTestOnBorrow(testOnBorrow);
    	druidDataSource.setTestOnReturn(testOnReturn);
    	druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
    	return druidDataSource;
    }
    
    
}
