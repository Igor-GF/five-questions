package nl.qs.fivequestions.service;

import nl.qs.fivequestions.model.Answer;
import nl.qs.fivequestions.model.Question;
import nl.qs.fivequestions.model.QuestionWrapper;
import nl.qs.fivequestions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<List<QuestionWrapper>> getQuestions() {
        try {
            List<Question> questionsFromDB = questionRepository.findAll();
            List<QuestionWrapper> questionsForUser = new ArrayList<>();

            for (Question q: questionsFromDB) {
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion());
                questionsForUser.add(qw);
            }

            return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public void saveAll(List<Question> questions) {
        questionRepository.saveAll(questions);
    }

    public ResponseEntity<String> postAnswers(List<String> answers) {
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> calculateResult(List<Answer> answers) {
        List<Question> questions = questionRepository.findAll();
        int rightOnes = 0;
        int i = 0;
        for (Answer answer: answers) {
            if (answer.getAnswer().equals(questions.get(i).getCorrectAnswer())) {
                rightOnes++;
            }
            i++;
        }
        return new ResponseEntity<>(rightOnes, HttpStatus.OK);
    }
}
