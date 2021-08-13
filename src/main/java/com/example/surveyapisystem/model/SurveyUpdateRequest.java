package com.example.surveyapisystem.model;

import com.example.surveyapisystem.entity.Question;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SurveyUpdateRequest {

    @ApiModelProperty(value = "Survey ID",position = 0)
    @NotNull
    private Long id;

    @ApiModelProperty(value = "Survey Question",position = 1)
    @NotBlank
    @Size(max = 140)
    private Question question;

    @ApiModelProperty(value = "Survey Options",position = 2)
    @NotNull
    @Size(min = 2,max = 6,message = "Choices must be betweeb 2 and 6")
    @Valid
    private List<AnswerRequestDTO> choices;

    public SurveyUpdateRequest() {
        super();
    }

}
