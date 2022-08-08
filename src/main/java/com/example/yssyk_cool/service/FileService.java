package com.example.yssyk_cool.service;


import com.example.yssyk_cool.dto.file.request.FileComplexRequest;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.exception.StorageException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface FileService extends BaseService<FileResponse, MultipartFile>{

    byte[] load(Long id)throws StorageException;

    List<FileResponse> save(MultipartFile[] attachments);
}
