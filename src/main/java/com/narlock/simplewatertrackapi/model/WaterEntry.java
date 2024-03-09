package com.narlock.simplewatertrackapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "WaterEntry")
public class WaterEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDate date = LocalDate.now();

    private Integer profileId;
    private Integer entry;
}
