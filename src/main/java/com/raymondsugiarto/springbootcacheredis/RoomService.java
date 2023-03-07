package com.raymondsugiarto.springbootcacheredis;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author raymond on 26/02/23
 */
@Service
@RequiredArgsConstructor
public class RoomService {

  @Cacheable(value = "room", key = "#id")
  public Room getRoom(Long id, boolean cache) {
    return Room.builder().id(1L).name("Java").build();
  }

  public Room getRoom(Long id) {
    return Room.builder().id(1L).name("Java").build();
  }

}
