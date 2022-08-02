package com.example.yssyk_cool.service;

import com.example.yssyk_cool.dto.file.request.FileComplexRequest;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.entity.FileComplex;
import com.example.yssyk_cool.exception.StorageException;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileComplexService extends BaseService<FileResponse, FileComplexRequest>{

    Resource load(Long id)throws StorageException;

    List<FileResponse> save(Long id, MultipartFile[] attachments);
}
