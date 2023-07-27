package com.satyam.QuizApplication.dao;

import com.satyam.QuizApplication.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);


    @Query(value = "SELECT * FROM question q WHERE q.category = ?1 ORDER BY rand() LIMIT ?2", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, Integer numQ);
}
