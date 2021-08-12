package com.example.surveyapisystem.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Table(name = "tbl_survey")
@Data
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 140)
	private String name;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate endDate;

	private String description;

	public Survey() {
		super();
	}

}
