package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.commonReference.response.AreaResponse;
import com.example.yssyk_cool.dto.commonReference.response.CommonResponse;
import com.example.yssyk_cool.service.CommonReferenceService;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/common-reference")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@ApiOperation("Получение района и города")
public class CommonReferenceController {

    final CommonReferenceService commonReferenceService;

    @GetMapping("/get-cities")
    @ApiOperation("Получить города")
    public List<CommonResponse> getCities(){
        return commonReferenceService.getCities();
    }

    @GetMapping("/get-areas")
    @ApiOperation("Получить районы")
    public List<CommonResponse> getAreas(){
        return commonReferenceService.getAreas();
    }

    @GetMapping("/get-type-complex")
    @ApiOperation("Получить типы комлексов")
    public List<CommonResponse> getTypeComplex(){
        return commonReferenceService.getTypeComplex();
    }
}
