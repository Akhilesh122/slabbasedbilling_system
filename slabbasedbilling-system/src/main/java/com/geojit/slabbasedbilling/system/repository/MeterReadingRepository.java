package com.geojit.slabbasedbilling.system.repository;

import com.geojit.slabbasedbilling.system.model.MeterReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading,Long> {
}
