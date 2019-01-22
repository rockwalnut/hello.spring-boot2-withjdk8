package com.example.demo.dto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.example.demo.uitility.Utility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.google.gson.Gson;

import org.aspectj.weaver.bcel.AtAjAttributes;

import javassist.bytecode.Descriptor.Iterator;

//import com.google.code.gson;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Identify implements Serializable {
    private static final long serialVersionUID = -9093033121193407925L;

    //special without +, +' +"
    public static final String specialChar = "[`~!@#$%^&*()_+./{}|:<>?]";
    
	//@ApiModelProperty(notes = "Server's status", example = "ok", position = 10)
	@JsonProperty("id")
    private String id;
    
    @JsonProperty("code")
    private String code;
    
    @JsonProperty("value")
	private String value;

	//@ApiModelProperty(notes = "Current server time (milliseconds)", example = "1545579500111", position = 20)
	@JsonProperty("language")
	private String language;

	//@ApiModelProperty(notes = "Current formated server time", example = "2018-01-01 12:00:45", position = 30)
	@JsonProperty("text")
	private String text;

	//@ApiModelProperty(notes = "Maven built time", example = "2017-12-31 12:00:45 GMT+0000 UTC", position = 40)
	@JsonProperty("order")
    private int order;

    @JsonProperty("translations")
    private Translation translations;

    public Identify() {

    }

    public Identify(String _code, Translation _trans) {

        this.translations = _trans;
        this.code = _code;
    }
    
    public Identify(String _id, String _lang, String _text, int _order) {
       
        this.id = _id;
        this.language = _lang;
        this.text = _text;
        this.order = _order;
    }

    public List<Identify> ListFromTLISQL()
    {
        BufferedReader reader;

        List<Identify>  result = new ArrayList<Identify>();
        List<String> lines = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(
					"./asset/sql/identify_type.sql"));
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
                String[] words = line.split(",");

                result.add(new Identify(
                words[1].replace("'", ""), 
                words[2].replace("'", ""), 

                words[3].replace("'", ""),  i));

                i++;
            
            } catch (IndexOutOfBoundsException e) {
                e.getMessage();
            }

        } 

        HashMap<Integer, List<Identify>> hashMap = new HashMap<Integer, List<Identify>>();
        List<Identify>  vars = new ArrayList<Identify>();

        //loop with reuslt
        for (Identify pre : result) {

            int id = 0;
            try {
                id = Integer.parseInt(pre.id);
            }
            catch (Exception ex) {

            }

            if (!hashMap.containsKey(id)) {
                List<Identify> list = new ArrayList<Identify>();
                list.add(pre);
            
                hashMap.put(id, list);
            } else {
                hashMap.get(id).add(pre);
            }
        }

        //loop to group
        for (List<Identify> value : hashMap.values()) {
            System.out.println("Value = " + value);

            Label en = new Label(value.get(0).text, value.get(0).text);
            Label th = new Label(value.get(1).text, value.get(1).text);

            Translation trans = new Translation(th, en);
            Identify temp = new Identify(value.get(0).id, trans);
            
            vars.add(temp);

        }

        //String json = new Gson().toJson(result);
        return vars;
    }

}