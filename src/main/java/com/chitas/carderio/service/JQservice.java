package com.chitas.carderio.service;

import com.chitas.carderio.model.api.AIResponse;
import com.chitas.carderio.model.api.Career;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;



@Service
public class JQservice {
    private final String APIKEY= "b116edccd7faa07443f4610fa7c44182936a40ce54deb73de9c458c4e72b3289";



        public Career generatePageJSON(String prompt) {
            String asd = """
        Generate structured JSON for a given career. The JSON must strictly follow this format:
        
        json

        {
            "title": "",
            "description": "",
            "responsibilities": [],
            "skills": [],
            "tasks": [
                { "description": "", "difficulty": "" },
                { "description": "", "difficulty": "" },
                { "description": "", "difficulty": "" }
            ],
            "quiz": [
                { "question": "", "options": ["", "", "", ""], "answer": "" },
                { "question": "", "options": ["", "", "", ""], "answer": "" }
            ]
        }
        Include:

        title: Name of the career.
        description: A short explanation of the career.
        responsibilities: A list of key duties.
        skills: A list of required skills.
        tasks: Three example tasks, each with a difficulty level ('easy', 'medium', or 'hard').
        quiz: Two multiple-choice questions with four answer options each and the correct answer specified.
        Return ONLY JSON, with no additional text. Generate it for: """ + prompt;

            // Escape newlines and quotes to avoid invalid JSON
            String safeAsd = asd.replace("\n", "\\n").replace("\"", "\\\"");

            HttpResponse<String> response;
            try {
                response = Unirest.post("https://api.together.xyz/v1/chat/completions")
                        .header("accept", "application/json")
                        .header("content-type", "application/json")
                        .header("authorization", "Bearer " + APIKEY)
                        .body("{\"model\":\"meta-llama/Meta-Llama-3.1-8B-Instruct-Turbo\",\"temperature\":1.0,\"context_length_exceeded_behavior\":\"error\",\"messages\":[{\"role\":\"user\",\"content\":\""+safeAsd+"\"}]}")
                        .asString();
            } catch (UnirestException e) {
                throw new RuntimeException("API request failed", e);
            }

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                // Step 1: Parse the API response into AIResponse
                AIResponse aiResponse = objectMapper.readValue(response.getBody(), AIResponse.class);

                // Step 2: Extract the nested JSON string from AI's message content
                String careerJson = aiResponse.getChoices().get(0).getMessage().getContent();

                // Step 3: Parse the actual career data
                return objectMapper.readValue(careerJson, Career.class);
            } catch (Exception e) {
                throw new RuntimeException("Failed to parse AI response", e);
            }
        }
    }





