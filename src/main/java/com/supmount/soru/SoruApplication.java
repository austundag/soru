package com.supmount.soru;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SoruApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		{
			Question obj = (Question) context.getBean("question");
			obj.setText("soru");

			System.out.println(obj.getText());
		}

		{
			User user = (User) context.getBean("user");
			user.setLastName("DOE");

			System.out.println(user.getName());
		}

		Question obj2 = (Question) context.getBean("question");
		System.out.println(obj2.getText());

		Answer answer = (Answer) context.getBean("answer");

		System.out.println("============================");
		System.out.println(answer.display());
		System.out.println("============================");

		context.registerShutdownHook();
		context.close();
	}
}
