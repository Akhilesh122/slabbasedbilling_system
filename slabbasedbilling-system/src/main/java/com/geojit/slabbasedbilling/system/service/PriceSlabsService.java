package com.geojit.slabbasedbilling.system.service;

import com.geojit.slabbasedbilling.system.exception.CustomException;
import com.geojit.slabbasedbilling.system.model.PriceSlabs;
import com.geojit.slabbasedbilling.system.repository.PriceSlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PriceSlabsService {
    @Autowired
    private PriceSlabRepository priceSlabRepository;

   public PriceSlabs savePriceSlabsDetails(PriceSlabs priceSlabs){
       if (Objects.nonNull(priceSlabRepository.findByStartDate(priceSlabs.getStartDate()))) {
           throw new CustomException("Start Date already present");
       }
       if (Objects.nonNull(priceSlabRepository.findByEndDate(priceSlabs.getEndDate()))) {
           throw new CustomException("End Date already present");
       }
       return priceSlabRepository.save(priceSlabs);
   }

   public List<PriceSlabs> getAllPriceSlabs(){
       return priceSlabRepository.findAll();
    }

    public PriceSlabs getAllPriceSlabsById(Long id){
       return priceSlabRepository.getById(id);
    }

    public PriceSlabs updatePriceSlabs(PriceSlabs priceSlabs,Long id){
       priceSlabs.setId(id);
       return priceSlabRepository.save(priceSlabs);
    }

    public void deletePriceSlabs(Long id){
       priceSlabRepository.deleteById(id);
    }
}
