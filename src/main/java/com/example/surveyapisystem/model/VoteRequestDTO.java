package com.example.surveyapisystem.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VoteRequestDTO {
    @NotNull
    private Long choiceId;

    public VoteRequestDTO() {
        super();
    }
}
