package com.narlock.simplewatertrackapi.repository;

import com.narlock.simplewatertrackapi.model.WeightEntry;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightEntryRepository extends JpaRepository<WeightEntry, Integer> {
  WeightEntry save(WeightEntry entry);

  WeightEntry saveAndFlush(WeightEntry entry);

  void deleteById(Integer id);

  Optional<WeightEntry> findById(Integer id);

  Optional<WeightEntry> findByDate(LocalDate date);

  List<WeightEntry> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
