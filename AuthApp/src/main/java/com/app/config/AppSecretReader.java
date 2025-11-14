package com.app.config;

import java.util.Locale;
import java.util.ResourceBundle;

public class AppSecretReader {
	
	static Locale setLocale(String lang, String country) {
//		Locale locale = new Locale("en", "US");
		Locale locale = Locale.of(lang, country);
		return locale;
	}
	
	public static String getPropertiesData(String key, String lang, String country) {
		ResourceBundle rb = ResourceBundle.getBundle("appSecrets", setLocale(lang, country));
		return rb.getString(key);
	}
}
