package com.satyam.QuizApplication.service;

import com.satyam.QuizApplication.dao.QuestionDao;
import com.satyam.QuizApplication.dao.QuizDao;
import com.satyam.QuizApplication.model.Question;
import com.satyam.QuizApplication.model.Quiz;
import com.satyam.QuizApplication.model.Response;
import com.satyam.QuizApplication.payloads.QuestionWrapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions =questionDao.findRandomQuestionByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz =quizDao.findById(id);
        List<Question> questions = quiz.get().getQuestionList();
        List<QuestionWrapper> questionWrappers = questions.stream().map((question) ->
            this.modelMapper.map(question,QuestionWrapper.class)).collect(Collectors.toList());
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz =quizDao.findById(id).get();
        List<Question> questions=quiz.getQuestionList();
        int right = 0;
        int i = 0;
        for(Response response :responses){
            if(response.getResponse().equals(questions.get(i).getCorrectAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
