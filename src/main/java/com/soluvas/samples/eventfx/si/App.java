package com.soluvas.samples.eventfx.si;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("META-INF/spring/*.xml");
	}
}
