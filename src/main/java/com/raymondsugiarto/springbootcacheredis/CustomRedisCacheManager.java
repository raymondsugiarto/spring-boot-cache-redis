//package com.raymondsugiarto.springbootcacheredis;
//
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.LoggerFactory;
//import org.springframework.cache.Cache;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.util.Assert;
//
//import java.util.concurrent.Callable;
//
///**
// * @author raymond on 06/03/23
// */
//@Slf4j
//class CustomRedisCacheManager extends RedisCacheManager {
//
//  public CustomRedisCacheManager(RedisTemplate redisTemplate) {
//    super(redisTemplate);
//  }
//
//  @Override
//  public Cache getCache(String name) {
//    return new RedisCacheWrapper(super.getCache(name));
//  }
//
//
//  protected static class RedisCacheWrapper implements Cache {
//
//    private final Cache delegate;
//
//    public RedisCacheWrapper(Cache redisCache) {
//      Assert.notNull(redisCache, "delegate cache must not be null");
//      this.delegate = redisCache;
//    }
//
//    @Override
//    public String getName() {
//      try {
//        return delegate.getName();
//      } catch (Exception e) {
//        return handleException(e);
//      }
//    }
//
//    @Override
//    public Object getNativeCache() {
//      try {
//        return delegate.getNativeCache();
//      } catch (Exception e) {
//        return handleException(e);
//      }
//    }
//
//    @Override
//    public Cache.ValueWrapper get(Object key) {
//      try {
//        return delegate.get(key);
//      } catch (Exception e) {
//        return handleException(e);
//      }
//    }
//
//    @Override
//    public <T> T get(Object o, Class<T> aClass) {
//      try {
//        return delegate.get(o, aClass);
//      } catch (Exception e) {
//        return handleException(e);
//      }
//    }
//
//    @Override
//    public <T> T get(Object o, Callable<T> callable) {
//      try {
//        return delegate.get(o, callable);
//      } catch (Exception e) {
//        return handleException(e);
//      }
//    }
//
//    @Override
//    public void put(Object key, Object value) {
//      try {
//        delegate.put(key, value);
//      } catch (Exception e) {
//        handleException(e);
//      }
//    }
//
//    @Override
//    public ValueWrapper putIfAbsent(Object o, Object o1) {
//      try {
//        return delegate.putIfAbsent(o, o1);
//      } catch (Exception e) {
//        return handleException(e);
//      }
//    }
//
//    @Override
//    public void evict(Object o) {
//      try {
//        delegate.evict(o);
//      } catch (Exception e) {
//        handleException(e);
//      }
//    }
//
//    @Override
//    public void clear() {
//      try {
//        delegate.clear();
//      } catch (Exception e) {
//        handleException(e);
//      }
//    }
//
//    private <T> T handleException(Exception e) {
//      log.error("handleException", e);
//      return null;
//    }
//  }
//}