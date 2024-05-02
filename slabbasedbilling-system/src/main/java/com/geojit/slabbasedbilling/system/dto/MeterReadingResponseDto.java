package com.geojit.slabbasedbilling.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeterReadingResponseDto {
    private Long id;
    private int currentReading;
    private int previousReading;
    private String month;
    private Long customerId;
}
