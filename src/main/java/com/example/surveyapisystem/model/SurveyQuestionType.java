package com.example.surveyapisystem.model;

public enum SurveyQuestionType {
	TEXT_RESPONSE,
	SINGLE_CHOICE,
	MULTIPLE_SELECTION;

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
