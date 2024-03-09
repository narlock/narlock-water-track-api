package com.narlock.simplewatertrackapi.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class WeightEntryRequest {
  private double weight;
  private LocalDate date;
  private String meta;

  public WeightEntry toWeightEntry() {
    return new WeightEntry(weight, date, meta);
  }
}
