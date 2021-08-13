package com.example.surveyapisystem.repository;

import com.example.surveyapisystem.entity.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT v FROM Vote v where v.user.id = :userId and v.survey.id in :surveyIds")
    List<Vote> findByUserIdAndSurveyIdIn(@Param("userId") Long userId, @Param("surveyIds") List<Long> surveyIds);

    @Query("SELECT v FROM Vote v where v.user.id = :userId and v.survey.id = :surveyId")
    Vote findByUserIdAndSurveyId(@Param("userId") Long userId, @Param("surveyId") Long surveyId);

    @Query("SELECT COUNT(v.id) from Vote v where v.user.id = :userId")
    long countByUserId(@Param("userId") Long userId);

    @Query("SELECT v.survey.id FROM Vote v WHERE v.user.id = :userId")
    Page<Long> findVotedSurveyIdsByUserId(@Param("userId") Long userId, Pageable pageable);

    long deleteByChoice_IdIn(List<Long> ids);
}

