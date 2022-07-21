package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.file.request.FileComplexRequest;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.entity.FileComplex;
import com.example.yssyk_cool.exception.NotFoundException;
import com.example.yssyk_cool.repository.ComplexRepository;
import com.example.yssyk_cool.repository.FileComplexRepository;
import com.example.yssyk_cool.repository.FileRepository;
import com.example.yssyk_cool.service.FileComplexService;
import com.example.yssyk_cool.service.FileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class FileComplexServiceImpl implements FileComplexService {

    final FileService fileService;

    final FileComplexRepository fileComplexRepository;

    final ComplexRepository complexRepository;

    final FileRepository fileRepository;


    @Override
    public FileResponse save(FileComplexRequest t) {
        FileResponse fileResponse = fileService.save(t);
        fileComplexRepository.save(FileComplex.builder()
                .complexes(complexRepository.findById(t.getComplexId()).orElseThrow(()-> new NotFoundException("complex not found", HttpStatus.BAD_REQUEST)))
                .fileMulti(fileRepository.findById(fileResponse.getId()).orElseThrow(()->new NotFoundException("file no found",HttpStatus.BAD_REQUEST)))
                .build());
        return fileResponse;
    }

    @Override
    public List<FileResponse> getAll() {
        return fileService.getAll();
    }

    @Override
    public FileResponse findById(Long id){
        return fileService.findById(id);
    }

    @Override
    public FileResponse delete(Long id) {
        return null;
    }
}
