package com.example.yssyk_cool.endpoint;

import java.util.List;

public interface BaseEndpoint<Response, Request> {

    Response save(Request t);

    List<Response> getAll();

    Response findById(Long id);

    Boolean delete(Long id);
}