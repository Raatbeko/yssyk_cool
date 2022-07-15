package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.file.request.FileComplexRequest;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.repository.FileRepository;
import com.example.yssyk_cool.service.ComplexService;
import com.example.yssyk_cool.service.FileComplexService;
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
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class FileComplexController {

    final FileComplexService fileService;

    final ComplexService complexService;

    @RequestMapping(value = "/save" , method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public FileResponse save(@ModelAttribute FileComplexRequest fileComplexRequest){
        return fileService.save(fileComplexRequest);
    }

    @GetMapping("/get-by-complex-id/{id}")
    public List<FileResponse> getByComplexId(@PathVariable Long id){
        return complexService.getAllFile(id);
    }

}
