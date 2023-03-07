package com.raymondsugiarto.springbootcacheredis;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author raymond on 03/03/23
 */
@Service
@RequiredArgsConstructor
public class CityService {

  private final CityRepository cityRepository;

  public City createCity() {
    return cityRepository.save(City.builder().id(UUID.randomUUID().toString()).name("abc").build());
  }

  public City getCity(String id) {
    return cityRepository.findById(id).orElseThrow();
  }
}
