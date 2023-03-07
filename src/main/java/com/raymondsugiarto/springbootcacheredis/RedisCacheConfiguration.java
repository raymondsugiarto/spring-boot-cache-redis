package com.raymondsugiarto.springbootcacheredis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;

/**
 * @author raymond on 06/03/23
 */
@Configuration
public class RedisCacheConfiguration extends CachingConfigurerSupport {

  @Override
  public CacheErrorHandler errorHandler() {
    return new RedisCacheErrorHandler();
  }
}
