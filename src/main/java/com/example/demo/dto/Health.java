package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.uitility.Utility;
import com.fasterxml.jackson.annotation.JsonProperty;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Health implements Serializable {
	private static final long serialVersionUID = -9093033121193407925L;

	//@ApiModelProperty(notes = "Server's status", example = "ok", position = 10)
	@JsonProperty("status")
	private String status;

	//@ApiModelProperty(notes = "Current server time (milliseconds)", example = "1545579500111", position = 20)
	@JsonProperty("serverDate")
	private Date serverDate;

	//@ApiModelProperty(notes = "Current formated server time", example = "2018-01-01 12:00:45", position = 30)
	@JsonProperty("formattedServerDate")
	private String formattedServerDate;

	//@ApiModelProperty(notes = "Maven built time", example = "2017-12-31 12:00:45 GMT+0000 UTC", position = 40)
	@JsonProperty("buildDate")
	private String buildDate;

	public Health() {
		this.serverDate = new Date();
		this.formattedServerDate = Utility.formatServerDate(this.serverDate);
	}

	public Health(String status, String buildDate) {
		this.status = status;
		this.serverDate = new Date();
		this.formattedServerDate = Utility.formatServerDate(this.serverDate);
		this.buildDate = buildDate;
	}

	public Health(String status, Date serverDate, String buildDate) {
		this.status = status;
		this.serverDate = serverDate;
		this.formattedServerDate = Utility.formatServerDate(this.serverDate);
		this.buildDate = buildDate;
	}
}