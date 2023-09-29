package com.example.ru.springbootmvc.repository;

import com.example.ru.springbootmvc.entity.PasteBoxEntity;

import java.util.List;

public interface PasteBoxRepository {

    PasteBoxEntity getByHash(String hash);
    List<PasteBoxEntity> getListPublicAndAlive(int amount);
    void add(PasteBoxEntity pasteBoxEntity);

}
