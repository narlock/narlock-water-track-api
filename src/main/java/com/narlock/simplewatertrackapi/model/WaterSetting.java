package com.narlock.simplewatertrackapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "WaterSetting")
public class WaterSetting {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer profileId;

  private Integer goal;
  private String unit;
}
