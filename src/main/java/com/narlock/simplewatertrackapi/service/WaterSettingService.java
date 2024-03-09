package com.narlock.simplewatertrackapi.service;

import com.narlock.simplewatertrackapi.model.WaterSetting;
import com.narlock.simplewatertrackapi.model.error.NotFoundException;
import com.narlock.simplewatertrackapi.repository.WaterSettingRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WaterSettingService {

  private final WaterSettingRepository waterSettingRepository;

  public WaterSetting createWaterSetting(WaterSetting waterSetting) {
    waterSettingRepository.saveByProfileIdGoalAndUnit(
        waterSetting.getProfileId(), waterSetting.getGoal(), waterSetting.getUnit());
    Optional<WaterSetting> waterSettingOptional =
        waterSettingRepository.findById(waterSetting.getProfileId());
    if (waterSettingOptional.isPresent()) {
      return waterSettingOptional.get();
    }

    throw new RuntimeException(
        "An unexpected error occurred when trying to retrieve a newly created water setting");
  }

  public WaterSetting getWaterSettingByProfileId(Integer profileId) {
    Optional<WaterSetting> waterSettingOptional = waterSettingRepository.findById(profileId);
    if (waterSettingOptional.isPresent()) {
      return waterSettingOptional.get();
    }

    throw new NotFoundException("Water Settings for profile " + profileId + " not found");
  }

  public WaterSetting updateWaterSetting(WaterSetting waterSetting) {
    return waterSettingRepository.save(waterSetting);
  }

  public void deleteWaterSettingByProfileId(Integer profileId) {
    waterSettingRepository.deleteById(profileId);
  }
}
