package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.commonReference.response.AreaResponse;
import com.example.yssyk_cool.dto.commonReference.response.CommonResponse;
import com.example.yssyk_cool.entity.CommonReference;
import com.example.yssyk_cool.mapper.CommonReferenceMapper;
import com.example.yssyk_cool.repository.CommonReferenceRepository;
import com.example.yssyk_cool.service.CommonReferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonReferenceServiceImpl implements CommonReferenceService {

    final CommonReferenceRepository commonReferenceRepository;

    @Override
    public List<CommonResponse> getCities() {

        return CommonReferenceMapper.INSTANCE.toResponse(commonReferenceRepository.findAllByTypeCode(1L));
    }

    @Override
    public List<CommonResponse> getAreas() {
        return CommonReferenceMapper.INSTANCE.toResponse(commonReferenceRepository.findAllByTypeCode(2L));
    }

    @Override
    public CommonReference getByTitle(String title) {
        return commonReferenceRepository.findByTitle(title);
    }

    @Override
    public CommonReference getByCode(Long code) {
        return null;
    }

    @Override
    public List<CommonResponse> getTypeComplex() {
        return CommonReferenceMapper.INSTANCE.toResponse(commonReferenceRepository.findAllByTypeCode(3L));
    }
}
