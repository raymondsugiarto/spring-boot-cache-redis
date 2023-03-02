package com.raymondsugiarto.springbootcacheredis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author raymond on 02/03/23
 */
@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country createCountry() {
        return countryRepository.save(Country.builder().id(UUID.randomUUID().toString()).name("Indonesia").build());
    }

    public Country getCountryById(String id) {
        return countryRepository.findById(id).orElse(null);
    }
}
