package com.example.demo.uitility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

public class Utility {
	public static final String PATTERN_SERVER_DATE = "yyyy-MM-dd HH:mm:ss";
	public static final int DIVIDER = 1000;

	private Utility() {
	}

	public static String getUniqueId() {
		return UUID.randomUUID().toString();
	}

	public static String formatServerDate(Date date) {
		if (date == null) {
			return "";
		}

		return new SimpleDateFormat(PATTERN_SERVER_DATE).format(date);
	}
	
	public static long getUnixTime() {
		return System.currentTimeMillis() / DIVIDER;
	}
	
	public static String getRevision(String data) {
		return DigestUtils.sha1Hex(data);
	}
	
	public static String getGUID() {
		return UUID.randomUUID().toString();
	}
	
	public static UUID getUUID() {
		return UUID.randomUUID();
	}
}
