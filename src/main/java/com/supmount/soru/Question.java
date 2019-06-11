package com.supmount.soru;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType")
@JsonSubTypes({
	@JsonSubTypes.Type(value=ChoiceQuestion.class, name="ChoiceQuestion"),
})
public class Question {
	private String text;
	private String type;

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void init() {
		System.out.println("Bean (Question) is going through init.");
	}

	public void destroy() {
		System.out.println("Bean (Question) will destroy now.");
	}

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (Exception ex) {
			return "";
		}
	}
}
