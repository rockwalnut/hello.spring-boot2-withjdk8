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
public class Result implements Serializable {
    private static final long serialVersionUID = -9093033121193407925L;

	//@ApiModelProperty(notes = "Server's status", example = "ok", position = 10)
	@JsonProperty("prenames")
    private List<Prename> prenames;

    @JsonProperty("occupations")
    private List<Occupation> occupations;

    @JsonProperty("identifys")
    private List<Identify> identifys;
    
    @JsonProperty("relations")
    private List<Relation> relations;


    //@JsonProperty("religions")
    //private List<Religion> religions;

    @JsonProperty("companys")
    private List<Company> companys;


    public Result() {

    }

    public Result(List<Prename> _pre, List<Occupation> _occ, List<Identify> _iden, List<Relation> _rels,
                     List<Company> _comp) {

        this.prenames = _pre;
        this.occupations = _occ;

        this.identifys = _iden;
        this.relations = _rels;

        this.companys = _comp;

    }

}