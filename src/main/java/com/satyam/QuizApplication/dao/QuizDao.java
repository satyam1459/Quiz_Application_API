package com.satyam.QuizApplication.dao;

import com.satyam.QuizApplication.model.Question;
import com.satyam.QuizApplication.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
