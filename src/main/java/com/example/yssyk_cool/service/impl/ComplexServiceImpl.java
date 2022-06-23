package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.complex.request.ComplexRequest;
import com.example.yssyk_cool.dto.complex.response.ComplexResponse;
import com.example.yssyk_cool.entity.FileComplex;
import com.example.yssyk_cool.repository.ComplexRepository;
import com.example.yssyk_cool.repository.FileComplexRepository;
import com.example.yssyk_cool.service.ComplexService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplexServiceImpl implements ComplexService {

    final ComplexRepository complexRepository;

    final FileComplexRepository fileComplex;

    @Override
    public ComplexResponse save(ComplexRequest t) {
        return null;
    }

    @Override
    public List<ComplexResponse> getAll() {
        return null;
    }

    @Override
    public ComplexResponse findById(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
