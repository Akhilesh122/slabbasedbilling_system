package com.geojit.slabbasedbilling.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeterReadingResponseDto {
    private Long id;
    private int reading;
    private Date date;
    private Long customerId;
}
