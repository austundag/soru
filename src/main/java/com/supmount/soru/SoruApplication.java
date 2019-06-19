package com.supmount.soru;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.supmount.razi.ConsentType;
import com.supmount.razi.ConsentTypeJDBCTemplate;
import com.supmount.razi.Language;
import com.supmount.razi.LanguageJDBCTemplate;
import com.supmount.razi.NewConsentType;

public class SoruApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		{
			Question obj = (Question) context.getBean("question");
			obj.setText("soru");

			System.out.println(obj.getText());
		}

		System.out.println("--------------------1");

		{
			User user = (User) context.getBean("user");
			user.setLastName("DOE");

			System.out.println(user.getName());
		}

		System.out.println("--------------------2");

		Question obj2 = (Question) context.getBean("question");
		System.out.println(obj2.getText());

		Answer answer = (Answer) context.getBean("answer");

		System.out.println("--------------------3");

		System.out.println("============================");
		System.out.println(answer.display());
		System.out.println("============================");

		System.out.println("****************************");
		System.out.println("****************************");

		LanguageJDBCTemplate languageJDBCTemplate = (LanguageJDBCTemplate) context.getBean("languageJDBCTemplate");

		List<Language> languages = languageJDBCTemplate.list();
		languages.forEach((language) -> {
			System.out.print("code: " + language.getCode());
			System.out.print(", name: " + language.getName());
			System.out.println(", native name: " + language.getNativeName());
			System.out.println(" ");
		});

		System.out.println("****************************");
		System.out.println("****************************");

		ConsentTypeJDBCTemplate consentTypeJDBCTemplate = (ConsentTypeJDBCTemplate) context
				.getBean("consentTypeJDBCTemplate");

		NewConsentType newConsentType = new NewConsentType();
		newConsentType.setName("daName");
		newConsentType.setType("daType");
		newConsentType.setRole("clinician");
		newConsentType.setTitle("daTitle");

		int ctid = consentTypeJDBCTemplate.create(newConsentType);

		ConsentType consentType = consentTypeJDBCTemplate.get(ctid, "en");
		System.out.println(consentType.toString());

		System.out.println("****************************");
		System.out.println("****************************");

		context.registerShutdownHook();
		context.close();
	}
}
