package com.geojit.slabbasedbilling.system.repository;

import com.geojit.slabbasedbilling.system.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {

    boolean existsByMeterReading_IdAndPriceSlabs_Id(Long meterReadingId, Long priceSlabsId);
}
