package com.example.surveyapisystem.service;

import com.example.surveyapisystem.entity.*;
import com.example.surveyapisystem.exception.ResourceNotFoundException;
import com.example.surveyapisystem.model.SurveyQuestionType;
import com.example.surveyapisystem.model.SurveyRequest;
import com.example.surveyapisystem.model.SurveyResponseDTO;
import com.example.surveyapisystem.repository.SurveyRepository;
import com.example.surveyapisystem.repository.UserRepository;
import com.example.surveyapisystem.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

   /* public List<SurveyResponseDTO> getAllSurveys() {

        List<SurveyResponseDTO> surveyResponses = surveyRepository.findAll().stream().map();

        return surveyResponses;
    }*/

    public Survey createSurvey(SurveyRequest surveyRequest) {
        Survey survey = new Survey();
        survey.setName(surveyRequest.getName());
        survey.setStartDate(surveyRequest.getStartDate());
        survey.setEndDate(surveyRequest.getEndDate());
        survey.setDescription(surveyRequest.getDescription());

        surveyRequest.getQuestions().forEach(questionRequest -> {
            survey.addQuestion(new Question(questionRequest.getText(), questionRequest.getQuestionType()));
        });

        return surveyRepository.save(survey);
    }



    /*public SurveyResponseDTO castVoteAndGetUpdatedSurvey(Long surveyId, Long voteRequest, Long id) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new ResourceNotFoundException("Survey", "id", surveyId));

        User user = userRepository.getOne(currentUser.getId());

        Choice selectedChoice = survey.getChoices().stream()
                .filter(choice -> choice.getId().equals(voteRequest))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Choice", "id", voteRequest));

        Vote vote = new Vote();
        vote.setSurvey(survey);
        vote.setUser(user);
        vote.setChoice(selectedChoice);

        try {
            vote = voteRepository.save(vote);
        } catch (DataIntegrityViolationException ex) {
            logger.info("User {} has already voted in Survey {}", currentUser.getId(), surveyId);
            throw new BadRequestException("Sorry! You have already cast your vote in this survey");
        }

        //-- Vote Saved, Return the updated Survey Response now --

        // Retrieve Vote Counts of every choice belonging to the current survey
        List<ChoiceVoteCount> votes = voteRepository.countBySurveyIdGroupByChoiceId(surveyId);

        Map<Long, Long> choiceVotesMap = votes.stream()
                .collect(Collectors.toMap(ChoiceVoteCount::getChoiceId, ChoiceVoteCount::getVoteCount));

        // Retrieve survey creator details
        *//*User creator = userRepository.findById(survey.getCreatedBy())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", survey.getCreatedBy()));*//*

        return ModelMapper.mapSurveyToSurveyResponse(survey, choiceVotesMap, creator, vote.getChoice().getId());
    }*/









}
