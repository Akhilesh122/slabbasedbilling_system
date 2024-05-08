package com.geojit.slabbasedbilling.system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
   // @Positive(message = "Rate per unit must be positive")
    private double rate;
    public void generateUnits(int index) {
        // Define the step size for each range
        int stepSize = 50;

        // Calculate start and end units automatically based on the given index and step size
        this.startUnit = index * stepSize;
        this.endUnit = (index + 1) * stepSize;

        // Determine rate automatically based on the range of units
        this.rate = determineRate(this.startUnit);
    }

    // Method to determine the rate based on the range of units
    private int determineRate(int startUnit) {
        // Assuming the rate increases by 10 for every range of 50 units
        return (startUnit / 50 + 1) * 10;
    }
}
