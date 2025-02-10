package com.chitas.carderio.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardDTO {
    private Long id;
    private String back;
    private String front;
}
