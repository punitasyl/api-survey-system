package com.example.surveyapisystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_votes", uniqueConstraints = {
		@UniqueConstraint(columnNames = {
				"survey_id",
				"user_id"
		})
})
@Data
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "survey_id", nullable = false)
	private Survey survey;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "answer_id", nullable = false)
	private Answer answer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Vote() {
		super();
	}

}
