package com.raymondsugiarto.springbootcacheredis;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raymond on 01/03/23
 */
@RestController
public class RoomController {

  @GetMapping("/room")
  public Room getRoom() {
//        return roomService.getRoom(2L);
    return getRoom2(2L);
  }

  // if call like this, not work. Why not works ?
  @Cacheable(value = "room", key = "#id")
  public Room getRoom2(Long id) {
    return Room.builder().id(1L).name("Java").build();
  }

}
