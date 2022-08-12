package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.file.request.FileComplexRequest;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.entity.FileComplex;
import com.example.yssyk_cool.entity.FileMulti;
import com.example.yssyk_cool.exception.NotFoundException;
import com.example.yssyk_cool.exception.StorageException;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Transactional
    public FileResponse save(FileComplexRequest t) {
        FileResponse fileResponse = fileService.save(t.getMultipartFile());
        fileComplexRepository.save(FileComplex.builder()
                .complexes(complexRepository.findById(t.getComplexId()).orElseThrow(() -> new NotFoundException("complex not found", HttpStatus.BAD_REQUEST)))
                .fileMulti(fileRepository.findById(fileResponse.getId()).orElseThrow(() -> new NotFoundException("file no found", HttpStatus.BAD_REQUEST)))
                .build());
        return fileResponse;
    }

    @Override
    @Transactional
    public List<FileResponse> save(Long complexId, MultipartFile[] attachments) {
        List<FileResponse> fileResponses = new ArrayList<>();

        for (MultipartFile attachment : attachments) {
            fileResponses.add(save(FileComplexRequest.builder()
                    .complexId(complexId)
                    .multipartFile(attachment)
                    .build()));
        }

        return fileResponses;

    }

    @Override
    public byte[] load(Long id) throws StorageException {
        return fileService.load(id);
    }

    @Override
    public FileResponse findById(Long id) {
        return fileService.findById(id);
    }

    @Override
    public List<FileResponse> getAll() {
        return fileService.getAll();
    }

    @Override
    public FileResponse delete(Long id) {
        FileMulti fileMulti = fileRepository.findById(id).orElseThrow();
        fileMulti.setDeletedAt(LocalDateTime.now());
        return FileResponse.builder()
                .url(fileMulti.getUrl())
                .id(fileMulti.getId())
                .build();
    }

}
