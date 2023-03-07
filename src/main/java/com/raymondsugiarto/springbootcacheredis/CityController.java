package com.raymondsugiarto.springbootcacheredis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author raymond on 03/03/23
 */
@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

  private final CityService cityService;

  @PostMapping
  public City createCity() {
    return cityService.createCity();
  }

  @GetMapping("{id}")
  public City createCity(@PathVariable("id") String id) {
    return cityService.getCity(id);
  }
}
