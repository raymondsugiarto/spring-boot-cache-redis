package com.raymondsugiarto.springbootcacheredis;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author raymond on 26/02/23
 */
@Service
@RequiredArgsConstructor
public class RoomService {

  @Cacheable(value = "room", key = "#id")
  public Room getRoom(Long id) {
    return Room.builder().id(1L).name("Java").build();
  }

}
