package com.geojit.slabbasedbilling.system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @Column(name = "cunsumer_id",unique = true)
    @NotNull(message = "Customer Id is mandatory")
    @Digits(integer = 13, fraction = 0, message = "Consumer ID must be a 13-digit number")
    private Long cunsumerId;
    @Column(name = "name",unique = true)
    @NotBlank(message = "Customer name is mandatory")
    private String name;
    @Column(name = "address",unique = true)
    @NotBlank(message = "Customer Address is mandatory")
    private String address;
}
