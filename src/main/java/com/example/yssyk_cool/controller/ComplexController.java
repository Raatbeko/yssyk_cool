package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.complex.request.ComplexRequest;
import com.example.yssyk_cool.dto.complex.response.ComplexResponse;
import com.example.yssyk_cool.service.ComplexService;
import com.example.yssyk_cool.service.FileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/complex")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplexController {

    final ComplexService complexService;

    @PostMapping("/save")
    public Long save(@RequestBody ComplexRequest complexRequest){
        return null;
    }

    @GetMapping("/get-by-id/{id}")
    public ComplexResponse getById(@PathVariable Long id){
        return null;
    }

    @GetMapping
    public List<ComplexResponse> getAll(){
        return null;
    }

    @GetMapping("/search/{search}")
    public List<ComplexResponse> search(@PathVariable String search){
        return null;
    }
}

