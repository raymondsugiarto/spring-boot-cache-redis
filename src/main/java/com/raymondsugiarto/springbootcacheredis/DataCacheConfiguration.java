package com.raymondsugiarto.springbootcacheredis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.integration.redis.util.RedisLockRegistry;

import java.time.Duration;

/**
 * @author raymond on 26/02/23
 */
@Configuration
@EnableCaching
public class DataCacheConfiguration {

//  @Bean
//  public RedisCacheConfiguration cacheConfiguration() {
//    return RedisCacheConfiguration.defaultCacheConfig()
//            .entryTtl(Duration.ofMinutes(60))
//            .disableCachingNullValues()
//            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//  }

  @Bean
  public RedisCacheManager redisCacheManager(LettuceConnectionFactory lettuceConnectionFactory) {

    /**
     * If we want to use JSON Serialized with own object mapper then use the below config snippet
     */
    // RedisCacheConfiguration redisCacheConfiguration =
    // RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues()
    // .entryTtl(Duration.ofHours(redisDataTTL)).serializeValuesWith(RedisSerializationContext.SerializationPair
    // .fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper)));

    RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues()
            .entryTtl(Duration.ofMinutes(60))
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));

    redisCacheConfiguration.usePrefix();

    RedisCacheManager redisCacheManager = RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(lettuceConnectionFactory)
            .cacheDefaults(redisCacheConfiguration).build();

    redisCacheManager.setTransactionAware(true);
    return redisCacheManager;
  }


  @Bean
  public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
    return new RedisLockRegistry(redisConnectionFactory, "my-lock-key", 30000L);
  }



}



