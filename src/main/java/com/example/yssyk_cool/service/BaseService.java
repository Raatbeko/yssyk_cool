package com.example.yssyk_cool.service;

import java.io.FileNotFoundException;
import java.util.List;

public interface BaseService<Response, Request> {

    Response save(Request t) throws Exception;

    List<Response> getAll();

    Response findById(Long id);

    Response delete(Long id);
}