package nl.qs.fivequestions.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import nl.qs.fivequestions.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class ExternalAPIService {
    private final RestTemplate restTemplate;
    private final QuestionService questionService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ExternalAPIService(RestTemplate restTemplate, QuestionService questionService) {
        this.restTemplate = restTemplate;
        this.questionService = questionService;
    }

    public String fetchDataFromExternalAPI(String apiUrl) {
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return "Error by fetching data from API";
        }
    }

    public void saveRespToDatabase(String apiData) {
        try {
            JsonNode tree = objectMapper.readTree(apiData);
            ArrayNode questionsNode = (ArrayNode) tree.get("results");

            ArrayList<Question> questions = new ArrayList<>();

            for (JsonNode q: questionsNode) {
                questions.add(objectMapper.treeToValue(q, Question.class));
            };
            System.out.println(questions);
            questionService.saveAll(questions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
