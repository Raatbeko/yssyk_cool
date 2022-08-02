package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.file.request.FileComplexRequest;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.exception.StorageException;
import com.example.yssyk_cool.repository.FileRepository;
import com.example.yssyk_cool.service.ComplexService;
import com.example.yssyk_cool.service.FileComplexService;
import com.example.yssyk_cool.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.FileEntity;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/file")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class FileComplexController {

    final FileComplexService fileService;

    final ComplexService complexService;

    final FileService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @ApiOperation("Сохранение фотки по id комплекса")
    public FileResponse save(@ModelAttribute MultipartFile multipartFile,
                             @PathVariable("id") Long complexId) {
        return fileService.save(FileComplexRequest.builder()
                .complexId(complexId)
                .multipartFile(multipartFile)
                .build());
    }

    @GetMapping("/get-by-complex-id/{id}")
    @ApiOperation("Получить все фотки комплекса по его id")
    public List<FileResponse> getAllByComplexId(@PathVariable Long id) {
        return complexService.getAllFile(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<InputStreamResource> getById(@PathVariable Long id) throws StorageException, IOException {

        InputStreamResource inputStreamResource = new InputStreamResource(fileService.load(id).getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(inputStreamResource);
    }

}
