package com.example.ru.springbootmvc.service;

import com.example.ru.springbootmvc.api.request.PasteBoxRequest;
import com.example.ru.springbootmvc.api.request.PublicStatus;
import com.example.ru.springbootmvc.api.responce.PasteBoxResponse;
import com.example.ru.springbootmvc.api.responce.PasteBoxUrlResponse;
import com.example.ru.springbootmvc.entity.PasteBoxEntity;
import com.example.ru.springbootmvc.repository.PasteBoxRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class PasteBoxServiceImpl implements PasteBoxService {

    private String host = "http:/adc.ru";
    private int publicListSize = 10;

   private final PasteBoxRepository pasteBoxRepository;
   private AtomicInteger idGenerator = new AtomicInteger(0);


    @Override
    public PasteBoxResponse getByHash(String hash) {

        PasteBoxEntity pasteBoxEntity = pasteBoxRepository.getByHash(hash);
        return new PasteBoxResponse(pasteBoxEntity.getData(), pasteBoxEntity.isPublic());
    }

    @Override
    public List<PasteBoxResponse> getPublicPasteBoxes() {
        List<PasteBoxEntity> list = pasteBoxRepository.getListPublicAndAlive(publicListSize);
        return list.stream().map(pasteBoxEntity ->
                        new PasteBoxResponse(pasteBoxEntity.getData()
                                , pasteBoxEntity.isPublic()))
                .collect(Collectors.toList());
    }

    @Override
    public PasteBoxUrlResponse create(PasteBoxRequest request) {
        int hash = generatedId();
        PasteBoxEntity pasteBoxEntity = new PasteBoxEntity();
        pasteBoxEntity.setData(request.getData());
        pasteBoxEntity.setId(hash);
        pasteBoxEntity.setHash(Integer.toHexString(hash));
        pasteBoxEntity.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        pasteBoxEntity.setLifeTime(LocalDateTime.now().plusSeconds(request.getExpirationTimeSeconds()));
        pasteBoxRepository.add(pasteBoxEntity);

        return new PasteBoxUrlResponse(host + "/" + pasteBoxEntity.getHash());

    }

    private int generatedId() {
        return idGenerator.getAndIncrement();
    }
}
