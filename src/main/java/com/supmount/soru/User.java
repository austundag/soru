package com.supmount.soru;

public class User {
	private String lastName;

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void init() {
		System.out.println("Bean (User) is going through init.");
	}

	public void destroy() {
		System.out.println("Bean (User) will destroy now.");
	}
}
