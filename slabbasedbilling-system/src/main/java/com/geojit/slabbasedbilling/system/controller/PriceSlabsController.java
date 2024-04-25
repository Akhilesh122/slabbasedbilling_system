package com.geojit.slabbasedbilling.system.controller;

import com.geojit.slabbasedbilling.system.model.PriceSlabs;
import com.geojit.slabbasedbilling.system.service.PriceSlabsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class PriceSlabsController {
    @Autowired
    private PriceSlabsService priceSlabsService;
    @PostMapping("/savePriceSlabs")
    public ResponseEntity<PriceSlabs> savePriceSlabs(@RequestBody PriceSlabs priceSlabs) throws ParseException {
        PriceSlabs priceSlabs1 = priceSlabsService.savePriceSlabsDetails(priceSlabs);
        return ResponseEntity.ok(priceSlabs1);
    }
    @GetMapping("/getAllPriceSlabs")
    public List<PriceSlabs> getAllPriceSlabs(){
         List<PriceSlabs> allPriceSlabs = priceSlabsService.getAllPriceSlabs();
         return allPriceSlabs;
    }
    @GetMapping("/getAllPriceSlabs/{id}")
    public ResponseEntity<PriceSlabs> getAllPriceSlabsById(@PathVariable Long id){
         PriceSlabs allPriceSlabsById = priceSlabsService.getAllPriceSlabsById(id);
        return ResponseEntity.ok(allPriceSlabsById);
    }

    @PutMapping("/updatePriceSlabs/{id}")
    public ResponseEntity<PriceSlabs> updatePriceSlabs(@RequestBody PriceSlabs priceSlabs, @PathVariable Long id){
         PriceSlabs priceSlabs1 = priceSlabsService.updatePriceSlabs(priceSlabs, id);
        return  ResponseEntity.ok(priceSlabs1);
    }
    @DeleteMapping("/deletePriceSlabs/{id}")
    public void deleteById(@PathVariable Long id){
        priceSlabsService.deletePriceSlabs(id);
    }
}
