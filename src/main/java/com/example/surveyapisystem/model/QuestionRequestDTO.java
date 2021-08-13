package com.example.surveyapisystem.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
public class QuestionRequestDTO {

    @NotBlank
    @Size(max = 40)
    @Setter
    @Getter
    private String text;

    @NotBlank
    @Getter
    @Setter
    private SurveyQuestionType questionType;


}
