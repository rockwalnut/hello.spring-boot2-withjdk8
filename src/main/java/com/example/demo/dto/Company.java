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
public class Company implements Serializable {
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

	//@ApiModelProperty(notes = "Maven built time", example = "2017-12-31 12:00:45 GMT+0000 UTC", position = 40)
	@JsonProperty("order")
    private int order;

    @JsonProperty("translations")
    private Translation translations;

    public Company()
    {

    }

    public Company(String _key, String _value)
    {
        this.key = _key;
        this.value = _value;
    }

    public Company(String _code, Translation _trans) {

        this.translations = _trans;
        this.code = _code;
    }

    public List<Company> ListFromJSON()
    {
        //BufferedReader reader;

        //List<Relation>  result = new ArrayList<Relation>();
        //List<String> lines = new ArrayList<>();

        CompanyList company = new CompanyList();

		try {
			/*reader = new BufferedReader(new FileReader(
					"./asset/json/DFL_RELATION.json"));
            String data = reader.*/

            String data = new String(Files.readAllBytes(Paths.get("./asset/json/DFL_INSURANCE_COMPANY.json")), StandardCharsets.UTF_8);
            
            Gson gson = new Gson();
            company = gson.fromJson(data, CompanyList.class);

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

       List<Company>  vars = new ArrayList<Company>();
        //loop with reuslt
        for (Company rel : company.getCompany()) {
            
            Label th = new Label(rel.value, rel.value);
            Label en = new Label(rel.value, rel.value);

            Translation trans = new Translation(th, en);
            Company temp = new Company(rel.key, trans);
            
            vars.add(temp);
        }

        //String json = new Gson().toJson(result);
        return vars;
    }

}
