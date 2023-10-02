package com.example.ru.springbootmvc.controller;

import com.example.ru.springbootmvc.api.request.PasteBoxRequest;
import com.example.ru.springbootmvc.api.responce.PasteBoxResponse;
import com.example.ru.springbootmvc.api.responce.PasteBoxUrlResponse;
import com.example.ru.springbootmvc.service.PasteBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;


@RestController
@RequiredArgsConstructor
public class PasteBoxController {
    private final PasteBoxService pasteBoxService;

    @GetMapping("/")
    public Collection<PasteBoxResponse> getPublicPasteList() {
        return pasteBoxService.getPublicPasteBoxes();
    }

    @GetMapping("/{hash}")
    public PasteBoxResponse getByHash(@PathVariable String hash) {
        return pasteBoxService.getByHash(hash);
    }

    @PostMapping("/")
    public PasteBoxUrlResponse add(@RequestBody PasteBoxRequest request) {
        return pasteBoxService.create(request);
    }

}
