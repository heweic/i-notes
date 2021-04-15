package org.mypro.study.apidemo.beanutil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

public class Test {

	
	
	
	public static void main(String[] args) {
		//
		Son source = new Son();
		
		source.setAge(11);
		source.setHead("black head。。");
		
		source.setName("nameVla");
		
		List<Toys> list = new ArrayList<Toys>();
		
		
		for(int i=  0 ; i < 2 ; i ++) {
			Toys toys = new Toys();
			toys.setName("name-" + i);
			toys.setSize( i * 10  + "");
			list.add(toys);
		}
		source.setToys(list);
		//
//		try {
//			Son target = (Son) source.clone();
//			System.out.println(new Gson().toJson(target));
//			
//			source.getToys().add(new Toys("修改", "修改"));
//			
//			System.out.println(new Gson().toJson(target));
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			Son target = new Son();
			BeanUtils.copyProperties(target, source);
			System.out.println(new Gson().toJson(target));
			source.getToys().add(new Toys("修改", "修改"));
			System.out.println(new Gson().toJson(target));
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


