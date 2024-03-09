package com.narlock.simplewatertrackapi.controller;

import com.narlock.simplewatertrackapi.model.WaterEntry;
import com.narlock.simplewatertrackapi.service.WaterEntryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/entry")
@RequiredArgsConstructor
public class WaterEntryController {

    private final WaterEntryService waterEntryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WaterEntry createWaterEntry(@RequestBody WaterEntry waterEntry) {
        return waterEntryService.createWaterEntry(waterEntry);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public WaterEntry getWaterEntryByDateProfile(@RequestParam(name = "date") LocalDate date,
                                                 @RequestParam(name = "profileId") Integer id) {
        return waterEntryService.getWaterEntryByDateProfile(date, id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public WaterEntry addToWaterEntryOnDateProfile(@RequestParam(name = "date") LocalDate date,
                                                   @RequestParam(name = "profileId") Integer id,
                                                   @RequestParam(name = "water") Integer amountOfWaterToAdd) {
        return waterEntryService.addToWaterEntryOnDateProfile(date, id, amountOfWaterToAdd);
    }
}
