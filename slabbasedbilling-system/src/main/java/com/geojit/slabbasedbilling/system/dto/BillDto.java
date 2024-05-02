package com.geojit.slabbasedbilling.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {
    private long id;
    private Long customerId;
    private Long meterReadingId;
    private Long priceSlabsId;
    private int unitsConsumed;
    private double totalAmount;
    private double gstAmount;
}
