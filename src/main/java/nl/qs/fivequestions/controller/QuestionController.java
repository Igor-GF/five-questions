package nl.qs.fivequestions.controller;

import nl.qs.fivequestions.model.Question;
import nl.qs.fivequestions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // get questions method
    @GetMapping("questions")
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }
    // post answers
//    @PostMapping("answers/check")
//    public void checkAnswers(@RequestBody) {
//
//    }
}
