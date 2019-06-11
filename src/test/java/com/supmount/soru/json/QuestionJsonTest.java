package com.supmount.soru.json;

import java.io.IOException;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supmount.soru.ChoiceQuestion;
import com.supmount.soru.Question;

public class QuestionJsonTest {
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() throws Exception {
		objectMapper = new ObjectMapper();
	}

	@AfterEach
	public void tearDown() throws Exception {
		objectMapper = null;
	}

	@Test
	public void testSerializingWithJsonIgnore() throws JsonProcessingException {
		Question question = new Question();
		question.setText("Da text?");
		question.setType("normal");

		String jsonString = objectMapper.writeValueAsString(question);

		System.out.println(jsonString);

		MatcherAssert.assertThat(jsonString, Matchers.containsString("Da text?"));
		MatcherAssert.assertThat(jsonString, Matchers.not(Matchers.containsString("narmal2")));
	}

	@Test
	public void testDeSerializingWithJsonIgnore() throws IOException {
		String jsonString = "{\"objectType\": \"Question\",   \"text\": \"Da2 text\", \"type\": \"normal2\"}";
		Question question = objectMapper.readValue(jsonString, Question.class);
		System.out.println(question);
		MatcherAssert.assertThat(question.getText(), Matchers.is(Matchers.equalTo("Da2 text")));
		MatcherAssert.assertThat(question.getType(), Matchers.is(Matchers.not(Matchers.equalTo("normal"))));
	}

	@Test
	public void testSerializingChoiceQuestion() throws JsonProcessingException {
		ChoiceQuestion question = new ChoiceQuestion();
		question.setText("Da text choice?");
		question.setType("choice");

		question.addChoice("choice 1");
		question.addChoice("choice 2");

		String jsonString = objectMapper.writeValueAsString(question);

		System.out.println(jsonString);

		MatcherAssert.assertThat(jsonString, Matchers.containsString("Da text choice?"));
		MatcherAssert.assertThat(jsonString, Matchers.not(Matchers.containsString("narmal2")));
	}

	@Test
	public void testDeSerializingChoiceQuestion() throws IOException {

		String jsonString = "{\"objectType\": \"ChoiceQuestion\", \"text\": \"Da2 text choice\", \"type\": \"choices2\", \"choices\": [\"choice1\", \"choice2\"]}";
		ChoiceQuestion question = objectMapper.readValue(jsonString, ChoiceQuestion.class);
		System.out.println(question);
		MatcherAssert.assertThat(question.getText(), Matchers.is(Matchers.equalTo("Da2 text choice")));
		MatcherAssert.assertThat(question.getType(), Matchers.is(Matchers.not(Matchers.equalTo("normal"))));
	}

}
