package com.example.surveyapisystem.service;

import com.example.surveyapisystem.entity.Survey;
import com.example.surveyapisystem.model.SurveyRequest;
import com.example.surveyapisystem.repository.SurveyRepository;
import com.example.surveyapisystem.repository.UserRepository;
import com.example.surveyapisystem.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.Instant;

public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

   /* public Survey createSurvey(SurveyRequest surveyRequest) {
        Survey survey = new Survey();
        survey.setQuestion(surveyRequest.getQuestion());

        surveyRequest.getChoices().forEach(choiceRequest -> {
            survey.addChoice(new Choice(choiceRequest.getText()));
        });

        Instant now = Instant.now();
        Instant expirationDateTime = now.plus(Duration.ofHours(surveyRequest.getSurveyExpiry().getHours()));

        survey.setExpirationDateTime(expirationDateTime);

        return surveyRepository.save(survey);
    }*/





}
