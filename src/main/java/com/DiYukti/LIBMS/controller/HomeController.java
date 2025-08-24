package com.DiYukti.LIBMS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @GetMapping("/healthCheck")
    public ResponseEntity<?> checkHealth()
    {
        return ResponseEntity.status(HttpStatus.OK).body("WORKING GOOD");
    }

    @GetMapping("/home")
    public ResponseEntity<?> home()
    {
        return ResponseEntity.status(HttpStatus.OK).body("This is home");
    }
}
