package com.geojit.slabbasedbilling.system.repository;

import com.geojit.slabbasedbilling.system.model.PriceSlabs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PriceSlabRepository extends JpaRepository<PriceSlabs,Long> {
    PriceSlabs findByStartDate(Date startDate);
    PriceSlabs findByEndDate(Date startDate);

}
