package com.supmount.soru;

public class Question {
	private String text;

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void init() {
		System.out.println("Bean (Question) is going through init.");
	}

	public void destroy() {
		System.out.println("Bean (Question) will destroy now.");
	}
}
