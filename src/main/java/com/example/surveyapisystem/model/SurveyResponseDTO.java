package com.example.surveyapisystem.model;

import com.example.surveyapisystem.entity.Question;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class SurveyResponseDTO {

    private Long id;

    private Question question;

    private List<AnswerResponseDTO> answers;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long selectedChoice;

    public SurveyResponseDTO() {
        super();
    }

}
