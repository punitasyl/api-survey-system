package com.example.surveyapisystem.repository;

import com.example.surveyapisystem.entity.Survey;
import com.example.surveyapisystem.model.SurveyResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Optional<Survey> findById(Long surveyId);

    List<Survey> findByIdIn(List<Long> surveyIds);

    List<Survey> findByIdIn(List<Long> surveyIds, Sort sort);
}
