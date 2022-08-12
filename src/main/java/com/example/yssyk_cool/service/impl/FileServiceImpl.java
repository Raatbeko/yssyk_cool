package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.entity.FileMulti;
import com.example.yssyk_cool.exception.FileNotFoundException;
import com.example.yssyk_cool.exception.StorageException;
import com.example.yssyk_cool.repository.FileRepository;
import com.example.yssyk_cool.service.FileService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class FileServiceImpl implements FileService {

    final FileRepository fileRepository;
    @Override
    public FileResponse save(MultipartFile file){
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            String URl = "C:\\Users\\Dell\\IdeaProjects\\yssyk_cool\\src\\main\\resources\\images\\";
            File tempFile = new java.io.File(URl);

            if (!tempFile.exists()) {
                tempFile.mkdir();
            }
            String fileName = getFileName(file) + "_" + formatDate(localDateTime) + "." + getExtension(file);

            String filePath = URl + fileName;
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

            FileMulti fileInDataBase = fileRepository.save(
                    FileMulti.builder()
                            .path(filePath)
                            .url(tempFile.getAbsolutePath())
                            .build()
            );

            return FileResponse.builder()
                    .id(fileInDataBase.getId())
                    .url(fileInDataBase.getUrl())
                    .build();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new FileResponse();
    }

    private static String getExtension(MultipartFile file) {

        String fullName = file.getOriginalFilename();

        assert fullName != null;
        int dot = fullName.lastIndexOf('.') + 1;

        return fullName.substring(dot);
    }

    private static String getFileName(MultipartFile file) {
        String fullName = file.getOriginalFilename();

        assert fullName != null;
        int dot = fullName.lastIndexOf('.');

        return fullName.substring(0, dot);
    }

    private static String formatDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
    }

    @Override
    public List<FileResponse> save(MultipartFile[] attachments) {
        List<FileResponse> fileResponses = new ArrayList<>();

        for (MultipartFile attachment : attachments) {
            fileResponses.add(save(attachment));
        }

        return fileResponses;
    }

    @Override
    public FileResponse findById(Long id) {
        FileMulti fileEntity = fileRepository.findById(id).orElseThrow(() -> new FileNotFoundException("file not found", HttpStatus.BAD_REQUEST));
        return FileResponse.builder()
                .id(fileEntity.getId())
                .url(fileEntity.getUrl())
                .build();
    }

    public byte[] load(Long id) throws StorageException {
        FileMulti fileEntity = fileRepository.findById(id).orElseThrow(() -> new FileNotFoundException("file not found", HttpStatus.BAD_REQUEST));
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(fileEntity.getPath()));
            byte[] theBytes = new byte[dis.available()];
            dis.read(theBytes, 0, dis.available());
            dis.close();
            return theBytes;

        } catch (IOException ex) {
            throw new StorageException("Файл не найден: " + fileEntity.getPath(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<FileResponse> getAll() {
        List<FileMulti> fileEntities = fileRepository.findAll();
        List<FileResponse> fileResponses = new ArrayList<>();

        for (FileMulti fileEntity : fileEntities) {

            fileResponses.add(FileResponse.builder()
                    .id(fileEntity.getId())
                    .url(fileEntity.getUrl()).build());

        }

        return fileResponses;
    }


    @Override
    public FileResponse delete(Long id) {
        return null;
    }


}
