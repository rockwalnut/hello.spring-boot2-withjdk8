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
public class Occupation implements Serializable {
    private static final long serialVersionUID = -9093033121193407925L;

    //special without +, +' +"
    public static final String specialChar = "[`~!@#$%^&*()_+./{}|:<>?]";
    
	//@ApiModelProperty(notes = "Server's status", example = "ok", position = 10)
	@JsonProperty("id")
	private String id;

	//@ApiModelProperty(notes = "Current server time (milliseconds)", example = "1545579500111", position = 20)
	@JsonProperty("language")
	private String language;

	//@ApiModelProperty(notes = "Current formated server time", example = "2018-01-01 12:00:45", position = 30)
	@JsonProperty("textTH")
    private String textTH;
    
    @JsonProperty("textEN")
	private String textEN;

	//@ApiModelProperty(notes = "Maven built time", example = "2017-12-31 12:00:45 GMT+0000 UTC", position = 40)
	@JsonProperty("order")
    private int order;

    public Occupation() {

    }
    
    public Occupation(String _id, String _textth, String _texten, int _order) {
       
        this.id = _id;
        //this.language = _lang;
        this.textTH = _textth;
        this.textEN = _texten;
        this.order = _order;
    }

    public List<Occupation> ListFromTLISQL()
    {
        BufferedReader reader;

        List<Occupation>  result = new ArrayList<Occupation>();
        List<String> lines = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(
					"./asset/sql/occupation.sql"));
			String line = reader.readLine();
			while (line != null) {
				// System.out.println(line);
		               
                if(!line.contains("INSERT"))
                {
                    lines.add(line);
                }

                // read next line
                line = reader.readLine();
                
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
        
        //loop
        int i =0;
        for (String line : lines) {
            try {

                //replace
                line = line.substring(line.indexOf("("), line.indexOf(")")).replaceAll(specialChar, "");

                int first = line.indexOf("'");
                int second = line.indexOf("'", first + 1);
                String tile = line.substring(first + 1, second);

                String[] words = line.split(",");

                result.add(new Occupation(
                words[0].replace("'", ""), 
                tile, //words[1].replace("'", ""),  
                words[2].replace("'", ""),  i));

                i++;
            
            } catch (IndexOutOfBoundsException e) {
                e.getMessage();
            }

        } 

        //String json = new Gson().toJson(result);

        return result;
    }

}