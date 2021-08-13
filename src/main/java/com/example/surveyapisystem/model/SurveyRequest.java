package com.example.surveyapisystem.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
public class SurveyRequest {

    @ApiModelProperty(value = "Survey Name",position = 1)
    @NotBlank
    @Size(max = 140)
    private String name;

    @ApiModelProperty(value = "Survey Options",position = 2)
    @NotNull
    @Size(min = 2,max = 6,message = "Choices must be between 2 and 6")
    @Valid
    private List<QuestionRequestDTO> questions;

    @ApiModelProperty(value = "Survey Options",position = 2)
    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    public SurveyRequest() {
        super();
    }


}
