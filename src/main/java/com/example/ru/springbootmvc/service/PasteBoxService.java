package com.example.ru.springbootmvc.service;

import com.example.ru.springbootmvc.api.request.PasteBoxRequest;
import com.example.ru.springbootmvc.api.responce.PasteBoxResponse;
import com.example.ru.springbootmvc.api.responce.PasteBoxUrlResponse;

import java.util.List;

public interface PasteBoxService {
    PasteBoxResponse getByHash(String hash);
    List<PasteBoxResponse> getPublicPasteBoxes();
    PasteBoxUrlResponse create(PasteBoxRequest request);
}
