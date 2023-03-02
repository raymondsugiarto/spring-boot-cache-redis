package com.raymondsugiarto.springbootcacheredis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raymond on 02/03/23
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("country")
public class CountryController {

  private final CountryService countryService;

  @PostMapping
  public Country createCountry() {
    return countryService.createCountry();
  }
}
