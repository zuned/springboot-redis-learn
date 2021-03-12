
import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

@Configuration
//@ConditionalOnProperty(value="cache.redis.enabled", havingValue = "true")
public class RedisConfig {
	
    @Value("${cache.redis.enabled:false}")
    private boolean isRedisCacheEnabled;
    
   
    
    @Value("${redis.host:localhost}")
    private String hostName;
    @Value("${redis.password:}")
    private String password;
    @Value("${redis.port:6379}")
    private int port;

    @Value("${redis.jedis.pool.max-total:100}")
    private int maxTotal;
    @Value("${redis.jedis.pool.max-idle:80}")
    private int maxIdle;
    @Value("${redis.jedis.pool.min-idle:20}")
    private int minIdle;
    @Value("${redis.jedis.pool.maxWaitMillis:2000}")
    private long maxWaitMillis;
    @Value("${redis.jedis.pool.blockWhenExhausted:true}")
    private boolean blockWhenExhausted;
    @Value("${redis.jedis.pool.testWhileIdle:true}")
    private boolean testWhileIdle;
    
    @Value("${redis.jedis.pool.timeBetweenEvictionRunsMillis:600000}")
    private long timeBetweenEvictionRunsMillis;
    
    @Value("${redis.jedis.pool.connectTimeoutMillis:2000}")
    private long connectTimeoutMillis;
    
    @Value("${redis.jedis.pool.readTimeoutMillis:2000}")
    private long readTimeoutMillis;

    @Value("${redis.jedis.pool.useSslFlag:false}")
    private boolean useSslFlag;
    
    @Value("${redis.jedis.pool.usePooling:true}")
    private boolean usePooling;

    @Bean
    public JedisClientConfiguration getJedisClientConfiguration() {
    	if(!isRedisCacheEnabled)
    		return null;
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisPoolingClientConfigurationBuilder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)JedisClientConfiguration.builder();
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMaxTotal(maxTotal);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxWaitMillis(maxWaitMillis);
        genericObjectPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        genericObjectPoolConfig.setTestWhileIdle(testWhileIdle);
        genericObjectPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
         jedisPoolingClientConfigurationBuilder.poolConfig(genericObjectPoolConfig)
        .and().connectTimeout(Duration.ofMillis(connectTimeoutMillis))
        .readTimeout(Duration.ofMillis(readTimeoutMillis));
         
         if(usePooling) {
        	 jedisPoolingClientConfigurationBuilder.and().usePooling();
         }
         
         if(useSslFlag) {
        	 jedisPoolingClientConfigurationBuilder.and().useSsl();
         }
         
         return jedisPoolingClientConfigurationBuilder.build();
//        return jedisPoolingClientConfigurationBuilder.poolConfig(genericObjectPoolConfig).build();
    }

    @Bean
    public JedisConnectionFactory getJedisConnectionFactory() {
    	if(!isRedisCacheEnabled)
    		return null;
    	//for cluster mode  
    	if(isRedisCacheEnabled) {
    		RedisClusterConfiguration redisClusterConfiguration = redisClusterConfiguration();
    		if (!StringUtils.isEmpty(password)) {
    			redisClusterConfiguration.setPassword(password);
    		}
    		return new JedisConnectionFactory(redisClusterConfiguration, getJedisClientConfiguration());
    	}
    	//for standalone mode  
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostName);
        redisStandaloneConfiguration.setPort(port);
        if(!StringUtils.isEmpty(password))
        {
            redisStandaloneConfiguration.setPassword(password);
        }
        return new JedisConnectionFactory(redisStandaloneConfiguration , getJedisClientConfiguration());
    }
    
    @Value("${redis.cluster.enabled:false}")
    private boolean isRedisClusterEnabled;
    @Value("${spring.redis.cluster.nodes:}")
    private String nodes;
    @Value("${spring.redis.cluster.max-redirects:3}")
    private int maxRedirects;
    @Bean
    public RedisClusterConfiguration redisClusterConfiguration(){
    	if(!isRedisClusterEnabled)
    		return null;
    	
    	RedisClusterConfiguration configuration 
    	= new RedisClusterConfiguration(Arrays.asList(nodes));
        configuration.setMaxRedirects(maxRedirects);
        return configuration;
    }
    
    @Bean
    public RedisTemplate<String,String> getRedisTemplate() {
    	if(!isRedisCacheEnabled)
    		return null;
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getJedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
	
}
