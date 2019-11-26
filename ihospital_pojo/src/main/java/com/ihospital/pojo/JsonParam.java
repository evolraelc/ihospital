package com.ihospital.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class JsonParam implements Serializable {
    @JsonProperty(value="data")
    private String data;


    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }
}
