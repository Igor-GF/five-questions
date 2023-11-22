package nl.qs.fivequestions.controller;

import nl.qs.fivequestions.model.Answer;
import nl.qs.fivequestions.model.QuestionWrapper;
import nl.qs.fivequestions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // get questions method
    @GetMapping("questions")
    public ResponseEntity<List<QuestionWrapper>> getQuestions() {
        return questionService.getQuestions();
    }

    // post answers
    @PostMapping("answers/submit")
    public ResponseEntity<Integer> submitAnswers(@RequestBody List<Answer> answers) {
        return questionService.calculateResult(answers);
    }
}
