package com.example.yssyk_cool.mapper;

import com.example.yssyk_cool.dto.commonReference.response.AreaResponse;
import com.example.yssyk_cool.dto.commonReference.response.CityResponse;
import com.example.yssyk_cool.entity.CommonReference;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommonReferenceMapper {
    CommonReferenceMapper INSTANCE = Mappers.getMapper(CommonReferenceMapper.class);

    List<CityResponse> toCityResponse(List<CommonReference> commonReference);

    List<AreaResponse> toAreaResponse(List<CommonReference> commonReference);
}
