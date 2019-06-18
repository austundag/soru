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

		context.registerShutdownHook();
		context.close();
	}
}
