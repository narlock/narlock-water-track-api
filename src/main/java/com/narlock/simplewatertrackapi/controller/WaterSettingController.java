package com.narlock.simplewatertrackapi.controller;

import com.narlock.simplewatertrackapi.model.WaterSetting;
import com.narlock.simplewatertrackapi.service.WaterSettingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/settings")
@RequiredArgsConstructor
public class WaterSettingController {

  private final WaterSettingService waterSettingService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public WaterSetting createWaterSetting(@RequestBody WaterSetting waterSetting) {
    return waterSettingService.createWaterSetting(waterSetting);
  }

  @GetMapping("/{profileId}")
  @ResponseStatus(HttpStatus.OK)
  public WaterSetting getWaterSettingByProfileId(@PathVariable("profileId") Integer profileId) {
    return waterSettingService.getWaterSettingByProfileId(profileId);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public WaterSetting updateWaterSetting(@RequestBody WaterSetting waterSetting) {
    return waterSettingService.updateWaterSetting(waterSetting);
  }

  @DeleteMapping("/{profileId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteWaterSettingByProfileId(@PathVariable("profileId") Integer profileId) {
    waterSettingService.deleteWaterSettingByProfileId(profileId);
  }
}
