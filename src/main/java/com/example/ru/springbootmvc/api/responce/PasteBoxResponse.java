package com.example.ru.springbootmvc.api.responce;

import com.example.ru.springbootmvc.api.request.PublicStatus;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PasteBoxResponse {
    private final String data;
    private final boolean isPublic;
}
