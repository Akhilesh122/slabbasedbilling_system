package com.geojit.slabbasedbilling.system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MeterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Min(value = 0, message = "Current reading cannot be negative")
    private int currentReading;
    //@Min(value = 0, message = "Previous reading cannot be negative")
    private int previousReading;
    @NotNull(message = "Month of reading is mandatory")
    private String month;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
