package com.geojit.slabbasedbilling.system.controller;

import com.geojit.slabbasedbilling.system.model.Bill;
import com.geojit.slabbasedbilling.system.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
   @Autowired
    private BillService billService;
   @PostMapping("/bills")
   public ResponseEntity<Bill> saveBillDetails(@RequestParam Long customerId,
                                               @RequestParam Long meterReadingId,
                                               @RequestParam Long priceSlabsId,Bill bill){

       Bill bills = billService.generateBill(customerId,meterReadingId,priceSlabsId,bill);

       return ResponseEntity.ok(bills);
   }

}
