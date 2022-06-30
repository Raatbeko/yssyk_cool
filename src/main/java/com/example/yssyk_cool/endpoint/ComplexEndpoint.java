package com.example.yssyk_cool.endpoint;

import com.example.yssyk_cool.dto.complex.request.ComplexRequest;
import com.example.yssyk_cool.dto.complex.response.ComplexResponse;

import java.util.List;

public interface ComplexEndpoint extends BaseEndpoint<ComplexResponse, ComplexRequest>{

    List<ComplexResponse> findAllByUserId(Long id);
}
