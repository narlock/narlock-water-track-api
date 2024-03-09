package com.narlock.simplewatertrackapi.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "WaterEntry")
public class WaterEntry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private LocalDate date = LocalDate.now();

  private Integer profileId;
  private Integer entry;
}
