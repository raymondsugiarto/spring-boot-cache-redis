package com.raymondsugiarto.springbootcacheredis;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

/**
 * @author raymond on 02/03/23
 */
@RedisHash("")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {

  @Id
  private String id;
  private String name;
}
