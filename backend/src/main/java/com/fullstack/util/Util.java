package com.fullstack.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class Util {
	
	public static double converte(String arg) throws ParseException{
	    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
	    double number = nf.parse(arg).doubleValue();
	    return number;
	}

}
