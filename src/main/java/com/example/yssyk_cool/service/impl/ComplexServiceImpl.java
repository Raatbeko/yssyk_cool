package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.complex.request.ComplexForUpdateRequest;
import com.example.yssyk_cool.dto.complex.request.ComplexRequest;
import com.example.yssyk_cool.dto.complex.response.ComplexResponse;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.entity.CommonReference;
import com.example.yssyk_cool.entity.Complex;
import com.example.yssyk_cool.enums.SearchType;
import com.example.yssyk_cool.exception.NotFoundException;
import com.example.yssyk_cool.mapper.ContactInfoMapper;
import com.example.yssyk_cool.mapper.location.LocationMapper;
import com.example.yssyk_cool.model.CategoryModel;
import com.example.yssyk_cool.model.SearchModel;
import com.example.yssyk_cool.repository.CommonReferenceRepository;
import com.example.yssyk_cool.repository.ComplexRepository;
import com.example.yssyk_cool.repository.FileComplexRepository;
import com.example.yssyk_cool.repository.UserRepository;
import com.example.yssyk_cool.service.*;
import com.example.yssyk_cool.service.auth.UserService;
import com.sun.el.stream.Stream;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplexServiceImpl implements ComplexService {

    final ComplexRepository complexRepository;

    final FileComplexRepository fileComplex;

    final FileComplexService fileService;

    final LocationService locationService;

    final ContactInfoService contactInfoService;

    final UserRepository userRepository;

    final UserService userService;

    final LocationMapper locationMapper;

    final CommonReferenceRepository commonReferenceRepository;


    @Override
    @Transactional
    public ComplexResponse save(
            ComplexRequest complexRequest,
            MultipartFile[] attachments
    ) {

        ComplexResponse complexResponse = save(complexRequest);
        complexResponse.setFileResponses(fileService.save(complexResponse.getId(), attachments));

        return complexResponse;
    }

    @Override
    public ComplexResponse save(ComplexRequest t) {
        CommonReference commonReference = commonReferenceRepository.findByTitle(t.getTypeComplex());
        Complex complex = complexRepository.save(Complex.builder()
                .complexName(t.getNameComplex())
                .typeComplex(commonReference)
                .aboutComplex(t.getAboutComplex())
                .contactInfo(contactInfoService.save(t.getContactInfoRequest()))
                .location(locationService.save(t.getLocationRequest()))
                .user(userRepository.findById(t.getCreatedById()).orElseThrow(() -> new NotFoundException("user not found", HttpStatus.BAD_REQUEST))).build());

        userService.addRoleToUser(t.getCreatedById());

        return toResponse(complex);

    }

    @Override
    public List<ComplexResponse> getAll() {

        return toResponse(complexRepository.findAll());
    }

    @Override
    public ComplexResponse findById(Long id) {
        Complex complex = complexRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found", HttpStatus.BAD_REQUEST));
        if (complex.getDeletedBy() == null)
            return toResponse(complex);
        throw new NotFoundException("its complex was deleted", HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional
    public ComplexResponse delete(Long id) {
        Complex complex = complexRepository.findById(id).orElseThrow(() -> new NotFoundException("Complex for delete not found", HttpStatus.BAD_REQUEST));
        complex.setDeletedBy(complex.getUser());
        complex.setDeletedAt(LocalDateTime.now());
        return toResponse(complex);

    }

    public List<FileResponse> getAllFile(Long id) {
        return fileComplex.findFileComplexByComplexesId(id).stream()
                .map(file -> FileResponse.builder()
                        .id(file.getFileMulti().getId())
                        .url(file.getFileMulti().getUrl())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public List<ComplexResponse> search(SearchModel searchModel) {

        List<ComplexResponse> complexResponses;

        if (searchModel.getSearchType().equals(SearchType.BY_AREA)) {
            complexResponses = getByArea(searchModel.getTitle());
            if (complexResponses.size() != 0) {
                return complexResponses;
            }
            throw new NotFoundException("Не найдено", HttpStatus.BAD_REQUEST);
        }

        if (searchModel.getSearchType().equals(SearchType.BY_CITY)) {
            complexResponses = getByCity(searchModel.getTitle());
            if (complexResponses.size() != 0) {
                return complexResponses;
            }
            throw new NotFoundException("Не найдено", HttpStatus.BAD_REQUEST);
        }

        if (searchModel.getSearchType().equals(SearchType.BY_COMPLEX_NAME)) {
            complexResponses = getComplexName(searchModel.getTitle());
            if (complexResponses.size() != 0) {
                return complexResponses;
            }
            throw new NotFoundException("Не найдено", HttpStatus.BAD_REQUEST);
        }
        return new ArrayList<>();
    }

    private List<ComplexResponse> getComplexName(String complexName) {
        List<Complex> complexes = complexRepository.findAll().stream().filter(complex -> complex.getComplexName().equalsIgnoreCase(complexName)).collect(Collectors.toList());
        return toResponse(complexes);
    }

    private List<ComplexResponse> getByCity(String title) {
        List<Complex> complexes = complexRepository.findAll().stream().filter(complex -> complex.getLocation().getCity().getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
        return toResponse(complexes);
    }

    private List<ComplexResponse> getByArea(String title) {
        List<Complex> complexes = complexRepository.findAll().stream().filter(complex -> complex.getLocation().getArea().getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
        return toResponse(complexes);
    }

    @Override
    public List<CategoryModel> getComplexInCity() {
        List<CategoryModel> categoryModels = new ArrayList<>();
        categoryModels.add(CategoryModel.builder()
                .cityName("Каракол")
                .complexResponses(toResponse(complexRepository.findByLocationCityTitle("Каракол")))
                .build());
        categoryModels.add(CategoryModel.builder()
                .cityName("Балыкчы ")
                .complexResponses(toResponse(complexRepository.findByLocationCityTitle("Балыкчы "))).build());
        categoryModels.add(CategoryModel.builder()
                .cityName("Чолпон-Ата")
                .complexResponses(toResponse(complexRepository.findByLocationCityTitle("Чолпон-Ата"))).build());
        return categoryModels;
    }

    @Override
    public boolean check(String check) {
        Complex complex = complexRepository.findByComplexName(check);

        return complex == null;
    }


    @Override
    public List<ComplexResponse> findAllByUserId(Long userId) {
        if (complexRepository.findAllByUserId(userId).size() == 0) {
            throw new NotFoundException("user not have any post", HttpStatus.BAD_REQUEST);
        }

        return toResponse(complexRepository.findAllByUserId(userId));
    }

    @Override
    @Transactional
    public ComplexResponse update(ComplexForUpdateRequest complexRequest) {

        CommonReference commonReference = commonReferenceRepository.findByTitle(complexRequest.getTypeComplex());
        Complex complex = complexRepository.findById(complexRequest.getComplexId()).orElseThrow(() -> new NotFoundException("complex not found", HttpStatus.BAD_REQUEST));
        complex.setComplexName(complexRequest.getNameComplex());
        complex.setTypeComplex(commonReference);
        complex.setContactInfo(contactInfoService.update(complexRequest.getContactInfoRequest()));
        complex.setLocation(locationService.update(complexRequest.getLocationRequest()));

        complexRepository.save(complex);

        return toResponse(complex);
    }

    private List<ComplexResponse> toResponse(List<Complex> complexes) {
        return complexes.stream().map(this::toResponse).collect(Collectors.toList());
    }

    private ComplexResponse toResponse(Complex complex) {
        return ComplexResponse.builder()
                .id(complex.getId())
                .typeComplex(complex.getTypeComplex().getTitle())
                .name(complex.getComplexName())
                .userId(complex.getUser().getId())
                .aboutComplex(complex.getAboutComplex())
                .contactInfoResponse(ContactInfoMapper.INSTANCE.toContactResponse(complex.getContactInfo()))
                .fileResponses(getAllFile(complex.getId()))
                .locationResponse(locationMapper.toLocationResponse(complex.getLocation()))
                .build();
    }
}
