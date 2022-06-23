package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.file.request.FileComplexRequest;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.repository.FileRepository;
import com.example.yssyk_cool.service.FileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.FileEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/file")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class FileController {

    final FileService fileService;

    @PostMapping("/save")
    FileResponse save(FileComplexRequest fileComplexRequest){
        return null;
    }

    @GetMapping("/get-by-complex-id/{id}")
    List<FileResponse> getByComplexId(@PathVariable("id") Long complexId){
        return null;
    }

}
