package com.example.surveyapisystem.model;

public enum SurveyQuestionType {

	MULTIPLE_SELECTION,

	SINGLE_CHOICE,

	TEXT_RESPONSE;

	public static SurveyQuestionType convert(String sqt) {
		switch (sqt) {
			case "MULTIPLE_SELECTION":
				return SurveyQuestionType.MULTIPLE_SELECTION;
			case "SINGLE_CHOICE":
				return SurveyQuestionType.SINGLE_CHOICE ;
			case "TEXT_RESPONSE":
				return SurveyQuestionType.TEXT_RESPONSE ;
			default:
				throw new RuntimeException("Unknown question type: " + sqt);
		}
	}

}
