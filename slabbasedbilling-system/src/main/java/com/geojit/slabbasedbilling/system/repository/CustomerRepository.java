package com.geojit.slabbasedbilling.system.repository;

import com.geojit.slabbasedbilling.system.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCunsumerId(Long cunsumerId);
    
}
