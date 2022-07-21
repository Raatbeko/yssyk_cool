package com.example.yssyk_cool.service;

import com.example.yssyk_cool.dto.complex.request.ComplexForUpdateRequest;
import com.example.yssyk_cool.dto.complex.request.ComplexRequest;
import com.example.yssyk_cool.dto.complex.response.ComplexResponse;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.entity.Complex;
import com.example.yssyk_cool.entity.FileMulti;
import com.example.yssyk_cool.entity.User;

import java.util.List;

public interface ComplexService extends BaseService<ComplexResponse, ComplexRequest>{

    List<ComplexResponse> findAllByUserId(Long userId);


    ComplexResponse update(ComplexForUpdateRequest complexRequest);

    List<FileResponse> getAllFile(Long complexId);

    List<ComplexResponse> search(String search);
}
