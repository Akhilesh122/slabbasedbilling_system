package com.geojit.slabbasedbilling.system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cunsumerId;
    public void generateConsumerId() {
        Random random = new Random();
        // Generate a random number between 0 and 999999
        long randomSuffix = random.nextLong() % 1000000;
        if (randomSuffix < 0) {
            // Ensure randomSuffix is positive
            randomSuffix += 1000000;
        }
        // Combine the fixed prefix with the random suffix
        this.cunsumerId = 1165410000000L + randomSuffix;
    }
    @Column(name = "name")
    @NotBlank(message = "Customer name is mandatory")
    private String name;
    @Column(name = "address")
    @NotBlank(message = "Customer Address is mandatory")
    private String address;
   /* @OneToMany
    private List<PriceSlabs> priceSlabs;
    @OneToMany
    private List<MeterReading> meterReadings;
    @OneToMany
    private List<Bill> bill;*/

}
