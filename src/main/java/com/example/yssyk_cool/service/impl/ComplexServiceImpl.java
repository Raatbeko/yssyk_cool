package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.complex.request.ComplexRequest;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.entity.Complex;
import com.example.yssyk_cool.entity.User;
import com.example.yssyk_cool.exception.NotFoundException;
import com.example.yssyk_cool.repository.ComplexRepository;
import com.example.yssyk_cool.repository.FileComplexRepository;
import com.example.yssyk_cool.repository.UserRepository;
import com.example.yssyk_cool.service.ComplexService;
import com.example.yssyk_cool.service.ContactInfoService;
import com.example.yssyk_cool.service.LocationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplexServiceImpl implements ComplexService {

    final ComplexRepository complexRepository;

    final FileComplexRepository fileComplex;

    final LocationService locationService;

    final ContactInfoService contactInfoService;

    final UserRepository userRepository;

    @Override
    public Complex save(ComplexRequest t) {
        return complexRepository.save(Complex.builder()
                .complexName(t.getName())
                .averagePrice(t.getAveragePrice())
                .contactInfo(contactInfoService.save(t.getContactInfoRequest()))
                .location(locationService.save(t.getLocationRequest()))
                .user(userRepository.findById(t.getCreatedById()).orElseThrow(()-> new NotFoundException("user not found",HttpStatus.NOT_FOUND))).build());
    }

    @Override
    public List<Complex> getAll() {
        return complexRepository.findAll();
    }

    @Override
    public Complex findById(Long id) {
        return complexRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public List<FileResponse> getAllFile(Long id) {
        return fileComplex.findFileComplexByComplexesId(id).stream()
                .map(file -> FileResponse.builder()
                        .id(file.getFileMulti().getId())
                        .url(file.getFileMulti().getUrl())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public List<Complex> findAllByUserId(Long userId) {
        return complexRepository.findAllByUserId(userId);
    }

}
