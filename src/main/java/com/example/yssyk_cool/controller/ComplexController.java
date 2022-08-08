package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.complex.request.ComplexForUpdateRequest;
import com.example.yssyk_cool.dto.complex.request.ComplexRequest;
import com.example.yssyk_cool.dto.complex.response.ComplexResponse;
import com.example.yssyk_cool.model.CategoryModel;
import com.example.yssyk_cool.model.SearchModel;
import com.example.yssyk_cool.service.ComplexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/complex")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class ComplexController {

    final ComplexService complexService;

    @GetMapping("/search")
    @ApiOperation("Поиск")
    public List<ComplexResponse> search(@RequestBody SearchModel searchModel) {
        return complexService.search(searchModel);
    }

    @GetMapping("/complex-in-cities")
    @ApiOperation("Получить комплексов по городам")
    public List<CategoryModel> getComplexInCities(){
        return complexService.getComplexInCity();
    }

    @PostMapping
    @ApiOperation("Сохранение комплекса")
    public ComplexResponse save(@RequestPart ComplexRequest complexRequest,
                                @RequestPart MultipartFile[] attachments
    ) throws FileNotFoundException {
        return complexService.save(complexRequest,attachments);
    }

    @PutMapping
    @ApiOperation("Обновить комплекс")
    public ComplexResponse update(@RequestBody ComplexForUpdateRequest complexRequest){
        return complexService.update(complexRequest);
    }

    @GetMapping("/{id}")
    @ApiOperation("Получить комплес по id")
    public ComplexResponse getById(@PathVariable Long id){
        return complexService.findById(id);
    }

    @GetMapping
    @ApiOperation("Получить все комплексы")
    public List<ComplexResponse> getAll() {
        return complexService.getAll();
    }

    @GetMapping("/get-by-user-id/{id}")
    @ApiOperation("Получить все посты одного провайдера по его id")
    public List<ComplexResponse> getByUserId(@PathVariable Long id){
        return complexService.findAllByUserId(id);
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Удалить комплек по id")
    public ComplexResponse delete(@PathVariable("id")Long id){
        return complexService.delete(id);
    }

    @GetMapping("/chek/{check}")
    public boolean checkName(@PathVariable String check){
        return complexService.check(check);
    }
}

