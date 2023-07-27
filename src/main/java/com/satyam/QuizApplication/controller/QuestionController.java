package com.satyam.QuizApplication.controller;

import com.satyam.QuizApplication.model.Question;
import com.satyam.QuizApplication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.NoSuchObjectException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @PostMapping("/questions")
    public List<Question> addQuestions(@RequestBody List<Question> questions){
        return questionService.addQuestions(questions);
    }

    @PutMapping("/question/{id}")
    public Question updateQuestion(@PathVariable Integer id,@RequestBody Question question) throws NoSuchObjectException {
        return questionService.updateQuestion(id,question);
    }
    @DeleteMapping("/question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) throws NoSuchObjectException {
        return questionService.deleteQuestion(id);
    }

    //get questions based on category
    @GetMapping("/questions/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

}
