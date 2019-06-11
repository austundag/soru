package com.supmount.soru;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChoiceQuestion extends Question {
	List<String> choices = new ArrayList<String>();

	public List<String> getChoices() {
		return Collections.unmodifiableList(choices);
	}

	public void addChoice(String choice) {
		choices.add(choice);
	}
}
