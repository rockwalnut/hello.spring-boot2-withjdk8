package com.example.demo.uitility;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Envi implements Serializable {
	private static final long serialVersionUID = 6473329379963163156L;

	//@Value("${owner}")
	//private String owner;

	@Value("${build.date}")
	private String buildDate;

	/*@Value("${storage.path}")
	private String storagePath;

	@Value("${aws.s3.access-key}")
	private String awsS3AccessKey;

	@Value("${aws.s3.secret-key}")
	private String awsS3SecretKey;

	@Value("${aws.s3.region}")
	private String awsS3Region;

	@Value("${aws.s3.bucket-name}")
	private String awsS3BucketName;*/
}
