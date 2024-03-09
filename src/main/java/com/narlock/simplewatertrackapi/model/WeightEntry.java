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
@Table(name = "WeightEntry")
public class WeightEntry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Double weight;
  private LocalDate date;
  private String meta;

  public WeightEntry(double weight, LocalDate date, String meta) {
    this.weight = weight;
    this.date = date;
    this.meta = meta;
  }
}
