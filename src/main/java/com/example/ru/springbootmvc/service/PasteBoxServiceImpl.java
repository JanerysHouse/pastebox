package com.example.ru.springbootmvc.service;

import com.example.ru.springbootmvc.api.request.PasteBoxRequest;
import com.example.ru.springbootmvc.api.responce.PasteBoxResponse;
import com.example.ru.springbootmvc.api.responce.PasteBoxUrlResponse;

import java.util.List;

public class PasteBoxServiceImpl implements PasteBoxService {
    @Override
    public PasteBoxResponse getByHash(String hash) {
        return null;
    }

    @Override
    public List<PasteBoxResponse> getPublicPasteBoxes(int amount) {
        return null;
    }

    @Override
    public PasteBoxUrlResponse create(PasteBoxRequest request) {
        return null;
    }
}
