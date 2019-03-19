package com.xlk.cache;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:redis.properties")//读取配置文件
public class RedisConfigure {

	@Value("${redis.hostName}")
	private String hostName;
	
	@Value("${redis.port}")
	private Integer port;
	
	@Value("${redis.maxIdle}")
    private Integer maxIdle;

    @Value("${redis.maxTotal}")
    private Integer maxTotal;

    @Value("${redis.maxWaitMillis}")
    private Integer maxWaitMillis;

    @Value("${redis.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;

    @Value("${redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;

    @Value("${redis.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${redis.testWhileIdle}")
    private boolean testWhileIdle;


    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes; //集群的节点

    @Value("${spring.redis.cluster.max-redirects}")
    private Integer maxRedirectsac;

   /* @Value("${redis.sentinel.host1}")
    private String sentinelHost1;
    
    @Value("${redis.sentinel.port1}")
    private Integer sentinelport1;
    
    @Value("${redis.sentinel.host2}")
    private String sentinelHost2;
    
    @Value("${redis.sentinel.port2}")
    private Integer sentinelport2;*/
    
    //key生成策略
    @Bean
	public KeyGenerator keyGenerator() {
	      return new KeyGenerator(){
	          @Override
	          public Object generate(Object target, java.lang.reflect.Method method, Object... params) {
	              StringBuffer sb = new StringBuffer();
	             sb.append(target.getClass().getName());
	              sb.append(method.getName());
	              for(Object obj:params){
	                  sb.append(obj.toString());
	              }
	              return sb.toString();
	          }
	      };
	  }
    
    //redis连接池
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
    	/**
    	 * 非springboot下 redis连接池
    	 * JedisPool jedisPool = new JedisPool(new GenericObjectPoolConfig(), "127.0.0.1", 6379);
    	 * Jedis jedis = jedisPool.getResource();
    	 * jedis.set()/.get();
    	 * jedis.close();最后需要关闭连接，代表归还连接池
    	 */
    	JedisPoolConfig jedisPoolConfig  = new JedisPoolConfig();
    	 // 最大空闲数
        jedisPoolConfig.setMaxIdle(maxIdle);
        // 连接池的最大数据库连接数
        jedisPoolConfig.setMaxTotal(maxTotal);
        // 最大建立连接等待时间
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
        jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        // 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        // 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        // 在空闲时检查有效性, 默认false
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        return jedisPoolConfig;
    }
    
    //单机版
    /*@Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
    	JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
    	jedisConnectionFactory.setPoolConfig(jedisPoolConfig);//连接池
    	jedisConnectionFactory.setHostName(hostName);//ip
    	jedisConnectionFactory.setPort(port);//端口
    	jedisConnectionFactory.setPassword("");
    	jedisConnectionFactory.setTimeout(5000);
    	return jedisConnectionFactory;
    }*/
    
    /**
     * redis集群
     * @return
     *  */
    @Bean
    public RedisClusterConfiguration redisClusterConfiguration() {
    	RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
    	String[] serverArray = clusterNodes.split(",");
    	Set<RedisNode> set = new HashSet<RedisNode>();
    	for(String redisNode : serverArray) {
    		String[] ipAndPort = redisNode.split(":");
    		set.add(new RedisNode(ipAndPort[0].trim(),Integer.valueOf(ipAndPort[1])));
    	}
    	redisClusterConfiguration.setClusterNodes(set);
    	redisClusterConfiguration.setMaxRedirects(maxRedirectsac);
    	return redisClusterConfiguration;
    }
    
    //配置集群工厂
    @Bean
    public JedisConnectionFactory JedisConnectionFactory(JedisPoolConfig jedisPoolConfig,RedisClusterConfiguration redisClusterConfiguration){
        JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration,jedisPoolConfig);
        return JedisConnectionFactory; 
    }
   
    
    /**
           * 配置redis的哨兵
     * @param redisConnectionFactory
     * @return
     
    @Bean
    public RedisSentinelConfiguration  redisSentinelConfiguration () {
    	RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
    	 //配置matser的名称
    	RedisNode masterredisNode = new RedisNode(sentinelHost1,sentinelport1);
    	masterredisNode.setName("mymaster");
    	redisSentinelConfiguration.master(masterredisNode);
    	//配置redis的哨兵sentinel
    	RedisNode senredisNode1 = new RedisNode(sentinelHost2,sentinelport2);//哨兵1
    	RedisNode senredisNode2 = new RedisNode("172.20.1.232",26379);////哨兵2
    	Set<RedisNode> redisSet = new HashSet<RedisNode>();
    	redisSet.add(senredisNode1);
    	redisSet.add(senredisNode2);
    	redisSentinelConfiguration.setSentinels(redisSet);
    	return redisSentinelConfiguration;
    }
    
    //配置工厂
    public JedisConnectionFactory jedisConnectionFactory(RedisSentinelConfiguration  redisSentinelConfiguration,JedisPoolConfig jedisPoolConfig) {
    	JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisSentinelConfiguration,jedisPoolConfig);
    	return jedisConnectionFactory;
    }
    */
    
    
    //实例化 RedisTemplate 对象
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    	RedisTemplate<String,Object>   redisTemplate = new RedisTemplate<>();
    	initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
    	return redisTemplate;
    }

	private void initDomainRedisTemplate(RedisTemplate<String,Object> redisTemplate, RedisConnectionFactory redisConnectionFactory) {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		//开启事务
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.setConnectionFactory(redisConnectionFactory);
	}
    
    
}
