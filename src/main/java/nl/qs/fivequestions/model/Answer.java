package nl.qs.fivequestions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Answer {
    @Id
    private Long answerId;
    private String answer;

    public Answer() {
    }

    public Answer(Long answerId, String answer) {
        setAnswerId(answerId);
        setAnswer(answer);
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
