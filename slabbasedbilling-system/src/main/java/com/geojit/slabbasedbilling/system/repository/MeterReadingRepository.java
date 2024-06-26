package com.geojit.slabbasedbilling.system.repository;

import com.geojit.slabbasedbilling.system.model.MeterReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading,Long> {

    List<MeterReading> findByCustomerIdOrderByDateAscReadingDesc(long customerId);
}
