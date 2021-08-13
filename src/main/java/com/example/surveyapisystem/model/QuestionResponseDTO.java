package com.example.surveyapisystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class QuestionResponseDTO {

	private List<AnswerResponseDTO> answers;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long selectedChoice;
}
