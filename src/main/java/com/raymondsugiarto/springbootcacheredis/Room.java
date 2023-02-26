package com.raymondsugiarto.springbootcacheredis;

import lombok.*;

/**
 * @author raymond on 26/02/23
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
  private Long id;
  private String name;
}
