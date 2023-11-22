package nl.qs.fivequestions.model;

import jakarta.persistence.Id;

public class QuestionWrapper {
    @Id
    private Long id;
    private String question;

    public QuestionWrapper(Long id, String question) {
        setId(id);
        setQuestion(question);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
