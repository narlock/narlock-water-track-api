package com.narlock.simplewatertrackapi.controller;

import com.narlock.simplewatertrackapi.model.DateWeightEntryResponse;
import com.narlock.simplewatertrackapi.model.WeightEntry;
import com.narlock.simplewatertrackapi.model.WeightEntryRequest;
import com.narlock.simplewatertrackapi.service.SimpleWaterTrackService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/weight")
@RequiredArgsConstructor
public class SimpleWaterTrackController {

  private final SimpleWaterTrackService simpleWeightTrackService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public WeightEntry createWeightEntry(@RequestBody WeightEntryRequest request) {
    return simpleWeightTrackService.createWeightEntry(request);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public WeightEntry readWeightEntryById(@PathVariable("id") Integer id) {
    return simpleWeightTrackService.readWeightEntryById(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public WeightEntry readWeightEntryByDate(
      @RequestParam(value = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
          LocalDate date) {
    return simpleWeightTrackService.readWeightEntryByDate(date);
  }

  @GetMapping("/range")
  @ResponseStatus(HttpStatus.OK)
  public DateWeightEntryResponse readWeightEntriesByStartEndDate(
      @RequestParam(value = "startDate", required = true)
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
          LocalDate startDate,
      @RequestParam(value = "endDate", required = true)
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
          LocalDate endDate) {
    return simpleWeightTrackService.readWeightEntriesByStartEndDate(startDate, endDate);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public WeightEntry updateWeightEntryById(
      @PathVariable("id") Integer id, @RequestBody WeightEntryRequest request) {
    return simpleWeightTrackService.updateWeightEntryById(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteWeightEntryById(@PathVariable("id") Integer id) {
    simpleWeightTrackService.deleteWeightEntryById(id);
  }
}
