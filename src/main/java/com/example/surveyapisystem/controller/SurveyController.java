package com.example.surveyapisystem.controller;


import com.example.surveyapisystem.model.*;
import com.example.surveyapisystem.entity.*;
import com.example.surveyapisystem.repository.*;
import com.example.surveyapisystem.service.SurveyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/surveys")
@Api(value = "Опрос", description = "Выполните все запросы, связанные с опросом", tags = {"Survey Resource"})
public class SurveyController {

	private SurveyRepository surveyRepository;

	private VoteRepository voteRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SurveyService surveyService;

	private static final Logger logger = LoggerFactory.getLogger(SurveyController.class);

	@Autowired // constructor base injection
	public SurveyController(SurveyRepository surveyRepository,VoteRepository voteRepository) {
		this.surveyRepository=surveyRepository;
		this.voteRepository=voteRepository;
	}

	@ApiOperation(value = "Создать опрос", tags = {"Survey Resource"})
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createSurvey(@Valid @RequestBody SurveyRequest surveyRequest) {
		Survey survey = surveyService.createSurvey(surveyRequest);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{surveyId}")
				.buildAndExpand(survey.getId()).toUri();

		return ResponseEntity.created(location)
				.body(new ApiResponseDTO(true, "Survey Created Successfully"));
	}



}
