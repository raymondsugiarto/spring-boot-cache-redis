package com.raymondsugiarto.springbootcacheredis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author raymond on 02/03/23
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {}
