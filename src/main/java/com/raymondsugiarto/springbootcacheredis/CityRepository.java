package com.raymondsugiarto.springbootcacheredis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author raymond on 03/03/23
 */
@Repository
public interface CityRepository extends JpaRepository<City, String> {}
