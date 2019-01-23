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
public class Product implements Serializable {
    private static final long serialVersionUID = -9093033121193407925L;

    //special without +, +' +"
    public static final String specialChar = "[`~!@#$%^&*()_+./{}|:<>?]";
    
	//@ApiModelProperty(notes = "Server's status", example = "ok", position = 10)
	@JsonProperty("id")
    private String id;
    
    @JsonProperty("code")
    private String code;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("name2")
    private String name2;
    
    @JsonProperty("payyear")
    private String payyear;
    
    @JsonProperty("pendowmentyear")
    private String pendownmentyear;
    
    @JsonProperty("paytype")
    private String paytype;

    @JsonProperty("endowmenttype")
    private String endowmenttype;
  
    @JsonProperty("disable")
    private String disable;

    @JsonProperty("discount")
    private String discount;

    @JsonProperty("matureamount")
    private String matureamount;

    @JsonProperty("minage")
    private String minage;

    @JsonProperty("maxage")
    private String maxage;

    @JsonProperty("minsum")
    private String minsum;

    @JsonProperty("maxsum")
    private String maxsum;

    private String lifepay;
    private String accpay;
    private String dividend;

    private String surrender;
    private String apl;
    private String minpremium;

    private String maxpremium;
    private String interestrate;
    private String loaninterest;

    private String devoid;
    private String policytype;
    private String approvedby;
    private String issuedate;
    private String enddate; 
    private String modeok;
    private String taxdeductflag;
    private String maxdeducttax;
    private String stepcode;
    private String ispackageplan;
    private String caltype;
    private String sex;
    private String amtofcoverage;
    private String pensionage;
    private String ridertype;
    private String planname3;

	@JsonProperty("order")
    private int order;

    @JsonProperty("translations")
    private Translation translations;


    public Product() {

    }

    //new with attrs
    public Product(String _code, String _name, String _name2, String _year,
                    int _order) {
        this.code = _code;
        this.name = _name;
        this.name2 = _name2;
        this.payyear = _year;

        this.order = _order;
    }

    public Product(String _code, Translation _trans) {

        this.translations = _trans;
        this.code = _code;
    }

    public List<Product> ListFromTLISQL()
    {
        BufferedReader reader;

        List<Product>  result = new ArrayList<Product>();
        List<String> lines = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(
					"./asset/sql/tlplan.sql"));
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

                result.add(new Product(
                words[0].replace("'", ""), 
                words[1].replace("'", ""),  
                words[2].replace("'", ""), 
                words[3].replace("'", ""),  i));

                i++;
            
            } catch (IndexOutOfBoundsException e) {
                e.getMessage();
            }

        } 


        List<Product>  vars = new ArrayList<Product>();
        //loop with reuslt
        for (Product pre : result) {
            
            Label th = new Label(pre.name, pre.name);
            Label en = new Label("", "");

            Translation trans = new Translation(th, en);
            Product temp = new Product(pre.id, trans);
            
            vars.add(temp);
        }

        //String json = new Gson().toJson(result);
        return vars;
    }

}