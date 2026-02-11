package com.companyQueryAI.samyukta;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String N8N_WEBHOOK =
            "http://localhost:5678/webhook/SamyuktaTechnology";

    @PostMapping("/chat")
    public Map<?, ?> chat(@RequestBody Map<String, String> payload) {

        Map<String, String> request = Map.of(
                "question", payload.get("message")
        );

        return restTemplate.postForObject(
                N8N_WEBHOOK,
                request,
                Map.class
        );
    }
}
