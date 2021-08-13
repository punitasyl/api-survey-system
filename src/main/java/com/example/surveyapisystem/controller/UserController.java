package com.example.surveyapisystem.controller;

import com.example.surveyapisystem.model.SurveyResponseDTO;
import com.example.surveyapisystem.repository.*;
import com.example.surveyapisystem.service.SurveyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Api(value = "Пользватели", description = "Чтобы получить подробную информацию о пользователе и опросы, принадлежащие этому конкретному пользователю", tags = {"User"})
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private VoteRepository voteRepository;

	@Autowired
	private SurveyService surveyService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);


	/*@ApiOperation(value = "Get Surveys Voted By User", tags = {"User Resource"})
	@GetMapping("/users/{id}/votes")
	public PageableResponse<SurveyResponseDTO> getSurveysVotedBy(@PathVariable(value = "id") String username,
																 @CurrentUser UserPrincipal currentUser,
																 @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
																 @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
		return surveyService.getSurveysVotedBy(username, currentUser, page, size);
	}*/


}
