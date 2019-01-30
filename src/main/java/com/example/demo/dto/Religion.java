package com.example.demo.dto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.example.demo.uitility.Utility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.google.gson.Gson;

import org.aspectj.weaver.bcel.AtAjAttributes;

//import com.google.code.gson;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Religion implements Serializable {
    private static final long serialVersionUID = -9093033121193407925L;

    //special without +, +' +"
    //public static final String specialChar = "[`~!@#$%^&*()_+./{}|:<>?]";
    
	//@ApiModelProperty(notes = "Server's status", example = "ok", position = 10)
	@JsonProperty("id")
    private String id;
    
    @JsonProperty("code")
    private String code;

    @JsonProperty("key")
    private String key;
    
    @JsonProperty("value")
    private String value;


	@JsonProperty("order")
    private int order;

    @JsonProperty("translations")
    private Translation translations;


    public Religion() {

    }

    //new with attrs
    public Religion(String _code, String _value, int _order) {
        this.code = _code;
        this.value = _value;
        this.order = _order;
    }

    public Religion(String _code, Translation _trans) {

        this.translations = _trans;
        this.code = _code;
    }

    public List<Religion> ListFromJSON()
    {
        //BufferedReader reader;

        //List<Religion>  result = new ArrayList<Religion>();
        //List<String> lines = new ArrayList<>();

        ReligionList religion = new ReligionList();

		try {
			/*reader = new BufferedReader(new FileReader(
					"./asset/json/DFL_RELATION.json"));
            String data = reader.*/

            String data = new String(Files.readAllBytes(Paths.get("./asset/json/DFL_RELIGION.json")), StandardCharsets.UTF_8);
            
            Gson gson = new Gson();
            religion = gson.fromJson(data, ReligionList.class);

			//reader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }


        /*try{
            reader = new BufferedReader(new FileReader("./asset/json/DFL_RELATION.json"));
            Gson gson = new GsonBuilder().create();
            Relation results = gson.fromJson(reader, Relation.class);
    
    
            }catch(Exception e){
                e.printStackTrace();
            }*/

       List<Religion>  vars = new ArrayList<Religion>();
        //loop with reuslt
        for (Religion rel : religion.getReligion()) {
            
            Label th = new Label(rel.value, rel.value);
            Label en = new Label(rel.value, rel.value);

            Translation trans = new Translation(th, en);
            Religion temp = new Religion(rel.key, trans);
            
            vars.add(temp);
        }

        //String json = new Gson().toJson(result);
        return vars;
    }

}