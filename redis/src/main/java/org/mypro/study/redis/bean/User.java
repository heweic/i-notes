package org.mypro.study.redis.bean;

import com.google.gson.Gson;

public class User {

	private String id;

	private String name;

	private int age;

	private int score;
	
	
	
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	
	
}
