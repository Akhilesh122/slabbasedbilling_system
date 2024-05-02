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
        // Generate a random number between 1000000000000 and 9999999999999
        this.cunsumerId = Math.abs(1000000000000L + random.nextLong() % 9000000000000L);
    }
    @Column(name = "name",unique = true)
    @NotBlank(message = "Customer name is mandatory")
    private String name;
    @Column(name = "address",unique = true)
    @NotBlank(message = "Customer Address is mandatory")
    private String address;
}
