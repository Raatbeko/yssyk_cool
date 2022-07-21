package com.example.yssyk_cool.service;


import com.example.yssyk_cool.dto.file.request.FileComplexRequest;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.exception.StorageException;
import org.springframework.core.io.Resource;

public interface FileService extends BaseService<FileResponse, FileComplexRequest>{

    Resource load(Long id)throws StorageException;
}
