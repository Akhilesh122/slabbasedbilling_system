package com.geojit.slabbasedbilling.system.controller;

import com.geojit.slabbasedbilling.system.dto.MeterReadingResponseDto;
import com.geojit.slabbasedbilling.system.model.MeterReading;
import com.geojit.slabbasedbilling.system.repository.CustomerRepository;
import com.geojit.slabbasedbilling.system.service.MeterReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeterReadingController {
    @Autowired
    private MeterReadingService meterReadingService;
    @Autowired
    private CustomerRepository customerRepository;
   @PostMapping("/saveMeterReading")
   public ResponseEntity<MeterReading> saveMeterReadings(@RequestBody MeterReadingResponseDto meterReadingResponseDto) {
       MeterReading meterReading = meterReadingService.saveMeterReadingDetails(meterReadingResponseDto);
       return new ResponseEntity<>(meterReading, HttpStatus.CREATED);
   }
    @GetMapping("/getAllMeterReading")
    public List<MeterReading> getAllMeterReadingDetails(){
         List<MeterReading> allMeterReading = meterReadingService.getAllMeterReading();
         return allMeterReading;
    }
    @GetMapping("/getAllMeterReading/{id}")
    public MeterReading getMeterReadingById(@PathVariable Long id){
         MeterReading meterReadingById = meterReadingService.getMeterReadingById(id);
        return meterReadingById;
    }
    @DeleteMapping("/deleteMeterReading/{id}")
    public void deleteMeterReading(@PathVariable Long id){
        meterReadingService.deleteByMeterReading(id);
    }
}
