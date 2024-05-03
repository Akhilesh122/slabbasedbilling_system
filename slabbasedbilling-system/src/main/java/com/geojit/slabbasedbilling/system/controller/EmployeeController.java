package com.geojit.slabbasedbilling.system.controller;

import com.geojit.slabbasedbilling.system.dto.ResponseDto;
import com.geojit.slabbasedbilling.system.dto.SignInDto;
import com.geojit.slabbasedbilling.system.dto.SignInResponseDto;
import com.geojit.slabbasedbilling.system.dto.SignUpDto;
import com.geojit.slabbasedbilling.system.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService userService;

    @PostMapping("/saveDetails")
    public ResponseDto signup(@Valid @RequestBody SignUpDto signUpDto) {
        return userService.signUp(signUpDto);
    }
    @PostMapping("/signIn")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto){
        return userService.signIn(signInDto);
    }

}
