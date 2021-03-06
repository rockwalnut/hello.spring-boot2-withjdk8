package com.example.demo.dto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.uitility.Utility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.google.gson.Gson;

import org.aspectj.weaver.bcel.AtAjAttributes;

//import com.google.code.gson;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Translation implements Serializable {
    //private static final long serialVersionUID = -9093033121193407925L;

    //special without +, +' +"
    //public static final String specialChar = "[`~!@#$%^&*()_+./{}|:<>?]";
    
	//@ApiModelProperty(notes = "Server's status", example = "ok", position = 10)
	@JsonProperty("th")
	private Label th;

	//@ApiModelProperty(notes = "Current server time (milliseconds)", example = "1545579500111", position = 20)
	//@JsonProperty("language")
	//private String language;

	//@ApiModelProperty(notes = "Current formated server time", example = "2018-01-01 12:00:45", position = 30)
	@JsonProperty("en")
    private Label en;


    public Translation(Label _th, Label _en)
    {
        this.en = _en;
        this.th = _th;

    }

}