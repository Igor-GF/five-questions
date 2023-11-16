package nl.qs.fivequestions.service;

import nl.qs.fivequestions.model.Question;
import nl.qs.fivequestions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public void saveAll(List<Question> questions) {
        questionRepository.saveAll(questions);
    }
}
