package com.xlk.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement //事务
public class SessionFactoryConfig implements TransactionManagementConfigurer{

	@Autowired
	private DataSource  dataSource;
	
	private static final Logger logger = LoggerFactory.getLogger(SessionFactoryConfig.class);
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean () {
		try {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);
			// 手写配置
            // 配置类型别名
			sqlSessionFactoryBean.setTypeAliasesPackage("com.xlk.entity");
			//配置mapper的扫描，找到所有的mapper.xml映射文件
			Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/xlk/dao/*.xml");
			System.out.println("xlk================="+resources.length);
			sqlSessionFactoryBean.setMapperLocations(resources);
			 // 加载全局的配置文件
			//sqlSessionFactoryBean.setConfigLocation( new DefaultResourceLoader().getResource("classpath:mybatis/mybatis-config.xml"));

            //添加插件 
			//sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper()});
            return sqlSessionFactoryBean;
		}catch(Exception e) {
			return null;
		}
	}
	
	@Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

	/*@Bean
    public PageHelper pageHelper(){
        logger.info("MyBatis分页插件PageHelper");
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }*/
}
