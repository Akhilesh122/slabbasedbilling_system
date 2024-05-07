package com.geojit.slabbasedbilling.system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="price_slabs")
public class PriceSlabs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   // @Min(value = 0, message = "Start unit cannot be negative")
    private int startUnit;
   // @Min(value = 1, message = "End unit must be greater than start unit")
    private int endUnit;
    @Positive(message = "Rate per unit must be positive")
    private double rate;
    public void generateUnits(int index) {
        // Generate start and end units automatically based on the given index and step size (50)
        this.startUnit = index * 50;
        this.endUnit = (index + 1) * 50;
    }
}
