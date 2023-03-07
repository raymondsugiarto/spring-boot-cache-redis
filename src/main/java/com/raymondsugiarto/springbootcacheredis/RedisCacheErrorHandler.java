package com.raymondsugiarto.springbootcacheredis;

import io.lettuce.core.RedisCommandTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * @author raymond on 06/03/23
 */
@Slf4j
public class RedisCacheErrorHandler implements CacheErrorHandler {

  @Override
  public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
    handleTimeOutException(exception);
    log.info("Unable to get from cache " + cache.getName() + " : " + exception.getMessage());
  }

  @Override
  public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
    handleTimeOutException(exception);
    log.info("Unable to put into cache " + cache.getName() + " : " + exception.getMessage());
  }

  @Override
  public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
    handleTimeOutException(exception);
    log.info("Unable to evict from cache " + cache.getName() + " : " + exception.getMessage());
  }

  @Override
  public void handleCacheClearError(RuntimeException exception, Cache cache) {
    handleTimeOutException(exception);
    log.info("Unable to clean cache " + cache.getName() + " : " + exception.getMessage());
  }

  /**
   * We handle redis connection timeout exception , if the exception is handled then it is treated as a cache miss and
   * gets the data from actual storage
   *
   * @param exception
   */
   private void handleTimeOutException(RuntimeException exception) {
     if (exception instanceof RedisCommandTimeoutException) {
       log.error("Redis connection timeout exception occurred", exception);
     }
   }
}