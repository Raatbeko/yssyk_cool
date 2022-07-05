package com.example.yssyk_cool.mapper;

import com.example.yssyk_cool.dto.commonReference.response.AreaResponse;
import com.example.yssyk_cool.dto.commonReference.response.CommonResponse;
import com.example.yssyk_cool.entity.CommonReference;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommonReferenceMapper {
    CommonReferenceMapper INSTANCE = Mappers.getMapper(CommonReferenceMapper.class);

    List<CommonResponse> toResponse(List<CommonReference> commonReference);

}
