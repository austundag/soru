package com.supmount.soru;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String lastName;
	private List names;

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public List getNames() {
		System.out.println("List Elements :" + names);
		return names;
	}

	public void setNames(List names) {
		this.names = names;
	}

	public String getName() {
		List<String> snames = new ArrayList<String>();
		names.forEach(r -> snames.add((String) r));
		return lastName + ", " + String.join(" ", snames);
	}

	public void init() {
		System.out.println("Bean (User) is going through init.");
	}

	public void destroy() {
		System.out.println("Bean (User) will destroy now.");
	}
}
