package com.narlock.simplewatertrackapi.repository;

import com.narlock.simplewatertrackapi.model.WaterEntry;
import com.narlock.simplewatertrackapi.model.WaterSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface WaterEntryRepository extends JpaRepository<WaterEntry, LocalDate> {

    @Modifying
    @Transactional
    @Query("INSERT INTO WaterEntry(date, profileId, entry) VALUES (:date, :profileId, :entry)")
    void saveByDate(
            @Param("date") LocalDate date,
            @Param("profileId") Integer profileId,
            @Param("entry") Integer entry
    );

    List<WaterEntry> findByProfileIdAndDate(Integer profileId, LocalDate date);
}
