package nl.qs.fivequestions.controller;

import nl.qs.fivequestions.model.Question;
import nl.qs.fivequestions.service.ExternalAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class APIController {
    private final ExternalAPIService externalAPIService;
    final String TRIVIA_API_QUESTIONS = "https://opentdb.com/api.php?amount=5&category=10&type=boolean";

    @Autowired
    public APIController(ExternalAPIService externalAPIService) {
        this.externalAPIService = externalAPIService;
    }

    @GetMapping("/fetch-data")
    public String fetchDataFromAPI() {
        String apiData = externalAPIService.fetchDataFromExternalAPI(TRIVIA_API_QUESTIONS);
        externalAPIService.saveRespToDatabase(apiData);
        return apiData;
    }
}
