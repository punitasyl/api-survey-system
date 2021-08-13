package com.example.surveyapisystem.model;

import lombok.Data;

@Data
public class ApiResponseDTO {

    private Boolean success;
    private String message;

    public ApiResponseDTO(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
