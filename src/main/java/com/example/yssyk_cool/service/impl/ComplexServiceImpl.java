package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.complex.request.ComplexRequest;
import com.example.yssyk_cool.dto.complex.response.ComplexResponse;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.entity.Complex;
import com.example.yssyk_cool.exception.NotFoundException;
import com.example.yssyk_cool.mapper.ContactInfoMapper;
import com.example.yssyk_cool.mapper.location.LocationMapper;
import com.example.yssyk_cool.repository.ComplexRepository;
import com.example.yssyk_cool.repository.FileComplexRepository;
import com.example.yssyk_cool.repository.UserRepository;
import com.example.yssyk_cool.service.ComplexService;
import com.example.yssyk_cool.service.ContactInfoService;
import com.example.yssyk_cool.service.LocationService;
import com.example.yssyk_cool.service.auth.UserService;
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

    final UserService userService;

    final LocationMapper locationMapper;

    @Override
    public ComplexResponse save(ComplexRequest t) {
        Complex complex = complexRepository.save(Complex.builder()
                .complexName(t.getName())
                .averagePrice(t.getAveragePrice())
                .contactInfo(contactInfoService.save(t.getContactInfoRequest()))
                .location(locationService.save(t.getLocationRequest()))
                .user(userRepository.findById(t.getCreatedById()).orElseThrow(() -> new NotFoundException("user not found", HttpStatus.BAD_REQUEST))).build());

        userService.addRoleToUser(t.getCreatedById());

        return ComplexResponse.builder()
                .id(complex.getId())
                .averagePrice(complex.getAveragePrice())
                .name(complex.getComplexName())
                .userId(complex.getUser().getId())
                .contactInfoResponse(ContactInfoMapper.INSTANCE.toContactResponse(contactInfoService.findById(complex.getId())))
                .fileResponses(getAllFile(complex.getId()))
                .locationResponse(locationMapper.toLocationResponse(complex.getLocation())
                ).build();

    }

    @Override
    public List<ComplexResponse> getAll() {

        return complexRepository.findAll().stream()
                .map(complex -> ComplexResponse.builder()
                        .id(complex.getId())
                        .averagePrice(complex.getAveragePrice())
                        .name(complex.getComplexName())
                        .userId(complex.getUser().getId())
                        .contactInfoResponse(ContactInfoMapper.INSTANCE.toContactResponse(complex.getContactInfo()))
                        .fileResponses(getAllFile(complex.getId()))
                        .locationResponse(locationMapper.toLocationResponse(complex.getLocation())
                        ).build()).collect(Collectors.toList());
    }

    @Override
    public ComplexResponse findById(Long id) {
        Complex complex = complexRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found", HttpStatus.BAD_REQUEST));

        return ComplexResponse.builder()
                .id(complex.getId())
                .averagePrice(complex.getAveragePrice())
                .name(complex.getComplexName())
                .userId(complex.getUser().getId())
                .contactInfoResponse(ContactInfoMapper.INSTANCE.toContactResponse(complex.getContactInfo()))
                .fileResponses(getAllFile(complex.getId()))
                .locationResponse(locationMapper.toLocationResponse(complex.getLocation())
                ).build();
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
    public List<ComplexResponse> findAllByUserId(Long userId) {
        if (complexRepository.findAllByUserId(userId).size() == 0){
            throw new NotFoundException("not found",HttpStatus.BAD_REQUEST);
        }

        return complexRepository.findAllByUserId(userId).stream()
                .map(complex -> ComplexResponse.builder()
                        .id(complex.getId())
                        .averagePrice(complex.getAveragePrice())
                        .name(complex.getComplexName())
                        .userId(complex.getUser().getId())
                        .contactInfoResponse(ContactInfoMapper.INSTANCE.toContactResponse(complex.getContactInfo()))
                        .fileResponses(getAllFile(complex.getId()))
                        .locationResponse(locationMapper.toLocationResponse(complex.getLocation()))
                        .build()).collect(Collectors.toList());
    }

}
