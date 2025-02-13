package com.chitas.carderio.model.api;


import lombok.Data;

@Data
public class CardCheck {

    private Boolean isCorrect;

    private Long cardId;

    private String localDateTime;
}
