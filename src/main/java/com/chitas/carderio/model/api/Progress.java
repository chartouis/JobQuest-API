package com.chitas.carderio.model.api;

import lombok.Data;

@Data
public class Progress {

    Long learn;
    Long know;

    public Progress(long learn, long know){
        this.learn = learn;
        this.know = know;
    }
}
