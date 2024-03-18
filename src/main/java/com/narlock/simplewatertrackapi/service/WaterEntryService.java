package com.narlock.simplewatertrackapi.service;

import com.narlock.simplewatertrackapi.model.WaterEntry;
import com.narlock.simplewatertrackapi.model.error.NotFoundException;
import com.narlock.simplewatertrackapi.repository.WaterEntryRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WaterEntryService {
  private final WaterEntryRepository waterEntryRepository;

  public WaterEntry createWaterEntry(WaterEntry waterEntry) {
    waterEntryRepository.saveByDate(
        waterEntry.getDate(), waterEntry.getProfileId(), waterEntry.getEntry());
    Optional<WaterEntry> waterEntryOptional = waterEntryRepository.findById(waterEntry.getDate());
    if (waterEntryOptional.isPresent()) {
      return waterEntryOptional.get();
    }

    throw new RuntimeException(
        "An unexpected error occurred when attempting to retrieve a newly created water entry");
  }

  public WaterEntry getWaterEntryByDateProfile(LocalDate localDate, Integer profileId) {
    List<WaterEntry> waterEntryList =
        waterEntryRepository.findByProfileIdAndDate(profileId, localDate);

    if (waterEntryList.size() > 1) {
      throw new RuntimeException(
          "Unexpected result from backend - more then one result for water entry on " + localDate);
    }

    if (!waterEntryList.isEmpty()) {
      return waterEntryList.get(0);
    }

    throw new NotFoundException("No water entry found on " + localDate);
  }

  public WaterEntry addToWaterEntryOnDateProfile(
      LocalDate date, Integer id, Integer amountOfWaterToAdd) {
    WaterEntry currentEntry = getWaterEntryByDateProfile(date, id);
    currentEntry.setEntry(currentEntry.getEntry() + amountOfWaterToAdd);
    return waterEntryRepository.save(currentEntry);
  }

  public List<WaterEntry> getWaterEntryByRange(LocalDate startDate, LocalDate endDate) {
    return waterEntryRepository.findByDateBetween(startDate, endDate);
  }
}
