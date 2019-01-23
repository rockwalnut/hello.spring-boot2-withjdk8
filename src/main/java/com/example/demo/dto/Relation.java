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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.aspectj.weaver.bcel.AtAjAttributes;

//import com.google.code.gson;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Relation implements Serializable {
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
    


	//@ApiModelProperty(notes = "Current server time (milliseconds)", example = "1545579500111", position = 20)
	//@JsonProperty("language")
	//private String language;

	//@ApiModelProperty(notes = "Current formated server time", example = "2018-01-01 12:00:45", position = 30)
	@JsonProperty("text")
    private String textTH;
    
    @JsonProperty("bene")
    private String bene;
    
    @JsonProperty("pay")
    private String pay;

    @JsonProperty("gua")
    private String gua;

	//@ApiModelProperty(notes = "Maven built time", example = "2017-12-31 12:00:45 GMT+0000 UTC", position = 40)
	@JsonProperty("order")
    private int order;

    @JsonProperty("translations")
    private Translation translations;

    public Relation()
    {

    }

    public Relation(String _code, Translation _trans, String _bene, String _pay, String _gua) {

        this.translations = _trans;
        this.code = _code;

        this.bene = _bene;
        this.pay = _pay;
        this.gua = _gua;
    }

    public List<Relation> ListFromJSON()
    {
        BufferedReader reader;

        List<Relation>  result = new ArrayList<Relation>();
        List<String> lines = new ArrayList<>();

        RelationList relations = new RelationList();

		try {
			/*reader = new BufferedReader(new FileReader(
					"./asset/json/DFL_RELATION.json"));
            String data = reader.*/

            String data = new String(Files.readAllBytes(Paths.get("./asset/json/DFL_RELATION.json")), StandardCharsets.UTF_8);
            
            Gson gson = new Gson();
            relations = gson.fromJson(data, RelationList.class);

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

       List<Relation>  vars = new ArrayList<Relation>();
        //loop with reuslt
        for (Relation rel : relations.getRelation()) {
            
            Label th = new Label(rel.value, rel.value);
            Label en = new Label(rel.value, rel.value);

            Translation trans = new Translation(th, en);
            Relation temp = new Relation(rel.key, trans, rel.bene, rel.pay, rel.gua);
            
            vars.add(temp);
        }

        //String json = new Gson().toJson(result);
        return vars;
    }

}
