package com.geojit.slabbasedbilling.system.exception;

import com.geojit.slabbasedbilling.system.model.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillResponse {
    private boolean success;
    private String message;
    private Bill bill;
}
