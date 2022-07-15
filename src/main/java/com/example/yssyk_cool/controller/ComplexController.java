package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.complex.request.ComplexRequest;
import com.example.yssyk_cool.dto.complex.response.ComplexResponse;
import com.example.yssyk_cool.service.ComplexService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/complex")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class ComplexController {

    final ComplexService complexService;

    @PostMapping("/save")
    public ComplexResponse save(@RequestBody ComplexRequest complexRequest) {
        return complexService.save(complexRequest);
    }

    @GetMapping("/{id}")
    public ComplexResponse getById(@PathVariable Long id) {
        return complexService.findById(id);
    }

    @GetMapping
    public List<ComplexResponse> getAll() {
        return complexService.getAll();
    }

    @GetMapping("/get-by-user-id/{id}")
    public List<ComplexResponse> getByUserId(@PathVariable Long id){
        return complexService.findAllByUserId(id);
    }

    @GetMapping("/search/{search}")
    public List<ComplexResponse> search(@PathVariable String search) {
        return null;
    }
}

