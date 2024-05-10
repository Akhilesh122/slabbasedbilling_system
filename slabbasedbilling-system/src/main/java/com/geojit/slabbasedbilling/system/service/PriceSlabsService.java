package com.geojit.slabbasedbilling.system.service;

import com.geojit.slabbasedbilling.system.dto.PriceSlabsDto;
import com.geojit.slabbasedbilling.system.model.PriceSlabs;
import com.geojit.slabbasedbilling.system.repository.CustomerRepository;
import com.geojit.slabbasedbilling.system.repository.PriceSlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceSlabsService {
    @Autowired
    private PriceSlabRepository priceSlabRepository;
    @Autowired
    private CustomerRepository customerRepository;

   public PriceSlabs savePriceSlabsDetails(PriceSlabsDto priceSlabsDto){

       Long customerId = priceSlabsDto.getCustomerId();

       PriceSlabs priceSlabs = new PriceSlabs();

       priceSlabs.setStartUnit(priceSlabsDto.getStartUnit());
       priceSlabs.setEndUnit(priceSlabsDto.getEndUnit());
       priceSlabs.setRate(priceSlabs.getRate());
       priceSlabs.generateUnits(0);
       priceSlabs.generateUnits(1);
       priceSlabs.generateUnits(2);
       priceSlabs.generateUnits(3);
       priceSlabs.generateUnits(4);
       priceSlabs.generateUnits(5);
       priceSlabs.generateUnits(6);
       priceSlabs.generateUnits(7);
       priceSlabs.generateUnits(8);

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
