package com.geojit.slabbasedbilling.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceSlabsDto {
    private long id;

    private int startUnit;

    private int endUnit;

    private double rate;

    private Long customerId;

}
