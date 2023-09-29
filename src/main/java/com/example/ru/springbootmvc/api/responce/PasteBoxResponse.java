package com.example.ru.springbootmvc.api.responce;

import com.example.ru.springbootmvc.api.request.PublicStatus;
import lombok.Data;

@Data
public class PasteBoxResponse {
    private String data;
    private PublicStatus status;
}
