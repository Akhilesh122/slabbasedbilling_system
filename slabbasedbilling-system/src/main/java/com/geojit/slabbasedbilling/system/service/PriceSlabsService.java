package com.geojit.slabbasedbilling.system.service;

import com.geojit.slabbasedbilling.system.model.PriceSlabs;
import com.geojit.slabbasedbilling.system.repository.PriceSlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceSlabsService {
    @Autowired
    private PriceSlabRepository priceSlabRepository;

   public PriceSlabs savePriceSlabsDetails(PriceSlabs priceSlabs){

       priceSlabs.generateUnits(0); // Generates startUnit = 0 and endUnit = 50

       priceSlabs.generateUnits(1); // Generates startUnit = 50 and endUnit = 100

       priceSlabs.generateUnits(2);//  Generates startUnit = 100 and endUnit = 150

       priceSlabs.generateUnits(3);//  Generates startUnit = 150 and endUnit = 200

       priceSlabs.generateUnits(4);//  Generates startUnit = 200 and endUnit = 250

       priceSlabs.generateUnits(5);//  Generates startUnit = 250 and endUnit = 300

       priceSlabs.generateUnits(6);//  Generates startUnit = 300 and endUnit = 350

       priceSlabs.generateUnits(7);//  Generates startUnit = 350 and endUnit = 400

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
