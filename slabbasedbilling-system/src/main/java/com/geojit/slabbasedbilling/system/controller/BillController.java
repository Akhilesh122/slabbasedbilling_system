package com.geojit.slabbasedbilling.system.controller;

import com.geojit.slabbasedbilling.system.dto.BillDto;
import com.geojit.slabbasedbilling.system.model.Bill;
import com.geojit.slabbasedbilling.system.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
   @Autowired
    private BillService billService;
    @PostMapping("/bills")
    public ResponseEntity<Bill> generateBill(@RequestBody BillDto billDto) {
        Bill bill = billService.generateBill(billDto);
        return new ResponseEntity<>(bill, HttpStatus.CREATED);
    }

}
