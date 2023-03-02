package com.raymondsugiarto.springbootcacheredis;

import lombok.RequiredArgsConstructor;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author raymond on 01/03/23
 */
@Service
@RequiredArgsConstructor
public class TransactionService {

  private final RedisLockRegistry redisLockRegistry;

  public String startTransaction() {
    Lock lock = redisLockRegistry.obtain("my-lock");
    try {
      if (lock.tryLock(10, TimeUnit.SECONDS)) {
        // Do something with the lock
//        throw new InterruptedException("test");
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } finally {
      lock.unlock();
    }

    return "success";
  }
}
