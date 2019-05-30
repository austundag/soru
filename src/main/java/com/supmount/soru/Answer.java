package com.supmount.soru;

public class Answer {
	private Question answerQuestion;
	private String value;

	public Question getAnswerQuestion() {
		return answerQuestion;
	}

	public void setAnswerQuestion(Question answerQuestion) {
		this.answerQuestion = answerQuestion;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void init() {
		System.out.println("Bean (Answer) is going through init.");
	}

	public void destroy() {
		System.out.println("Bean (Answer) will destroy now.");
	}

	public String display() {
		String questionText = answerQuestion == null ? "null" : answerQuestion.getText();
		String answer = value == null ? "null" : value;
		return questionText + ": " + answer;
	}
}
