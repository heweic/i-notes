package org.mypro.study.apidemo.future;

import java.util.Calendar;
import java.util.Date;

public class Test {
	
	
	public static void main(String[] args) {
		
		//1611801532
		Calendar calendar = Calendar.getInstance();
		long time = 1611801532L * 1000;
		System.out.println(time);
		//calendar.setTime(new Date(time));
		
		System.out.println(calendar.getTimeInMillis());
		System.out.println(calendar.get(Calendar.YEAR));
	}

}


