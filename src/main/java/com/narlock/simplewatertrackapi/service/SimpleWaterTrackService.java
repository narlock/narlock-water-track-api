package com.narlock.simplewatertrackapi.service;

import com.narlock.simplewatertrackapi.model.DateWeightEntryResponse;
import com.narlock.simplewatertrackapi.model.WeightEntry;
import com.narlock.simplewatertrackapi.model.WeightEntryRequest;
import com.narlock.simplewatertrackapi.model.error.NotFoundException;
import com.narlock.simplewatertrackapi.repository.WeightEntryRepository;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleWaterTrackService {

  private final WeightEntryRepository weightEntryRepository;

  public WeightEntry createWeightEntry(WeightEntryRequest request) {
    WeightEntry entryToCreate = request.toWeightEntry();
    return weightEntryRepository.save(entryToCreate);
  }

  public WeightEntry readWeightEntryById(Integer id) {
    Optional<WeightEntry> weightEntryOptional = weightEntryRepository.findById(id);
    if (weightEntryOptional.isPresent()) {
      return weightEntryOptional.get();
    } else {
      throw new NotFoundException("Entry not found for id " + id);
    }
  }

  public DateWeightEntryResponse readWeightEntriesByStartEndDate(
      LocalDate startDate, LocalDate endDate) {
    List<WeightEntry> entries = weightEntryRepository.findByDateBetween(startDate, endDate);
    // Sort the entries to make sure they are returned in order by date
    Collections.sort(entries, Comparator.comparing(WeightEntry::getDate));
    return DateWeightEntryResponse.builder()
        .startDate(startDate)
        .endDate(endDate)
        .count(entries.size())
        .entries(entries)
        .build();
  }

  public WeightEntry updateWeightEntryById(Integer id, WeightEntryRequest request) {
    WeightEntry entryToUpdate = request.toWeightEntry();
    entryToUpdate.setId(id);
    return weightEntryRepository.saveAndFlush(entryToUpdate);
  }

  public void deleteWeightEntryById(Integer id) {
    weightEntryRepository.deleteById(id);
  }

  public WeightEntry readWeightEntryByDate(LocalDate date) {
    Optional<WeightEntry> weightEntryOptional = weightEntryRepository.findByDate(date);
    if (weightEntryOptional.isPresent()) {
      return weightEntryOptional.get();
    } else {
      throw new NotFoundException("Entry not found for date " + date.toString());
    }
  }
}
