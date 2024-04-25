package com.geojit.slabbasedbilling.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Customer association is mandatory")
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @NotNull(message = "Meter reading association is mandatory")
    @ManyToOne
    @JoinColumn(name = "meter_id")
    private MeterReading meterReading;
    @NotNull(message = "Applied tariff association is mandatory")
    @ManyToOne
    @JoinColumn(name = "price_id")
    private PriceSlabs priceSlabs;
    private int unitsConsumed;
    private double totalAmount;
    private double gstAmount;
}
