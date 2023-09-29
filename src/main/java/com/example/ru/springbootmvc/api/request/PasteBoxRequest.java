package com.example.ru.springbootmvc.api.request;


import lombok.Data;

@Data
public class PasteBoxRequest {
    private String data;
    private long expirationTimeSeconds;
    private PublicStatus publicStatus;
}
