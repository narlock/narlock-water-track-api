package com.narlock.simplewatertrackapi.repository;

import com.narlock.simplewatertrackapi.model.WaterSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface WaterSettingRepository extends JpaRepository<WaterSetting, Integer> {

    @Modifying
    @Transactional
    @Query("INSERT INTO WaterSetting(profileId, goal, unit) VALUES (:profileId, :goal, :unit)")
    void saveByProfileIdGoalAndUnit(
            @Param("profileId") Integer profileId,
            @Param("goal") Integer goal,
            @Param("unit") String unit
    );
}
