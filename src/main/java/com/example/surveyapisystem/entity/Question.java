package com.example.surveyapisystem.entity;

import com.example.surveyapisystem.model.SurveyQuestionType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "tbl_question")
@Data
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 40)
	private String text;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "survey_id", nullable = false)
	private Survey survey;

	private SurveyQuestionType questionType;

	public Question() {
		super();
	}

	public Question(@NotBlank @Size(max = 40) String text, SurveyQuestionType questionType) {
		this.text = text;
		this.questionType = questionType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Question question = (Question) o;
		return Objects.equals(id, question.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
