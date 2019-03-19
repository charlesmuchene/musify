package dev.cstv.musify.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context/applicationContext.xml");
    static TestData testData=context.getBean("testData",TestData.class);

    public static void main(String[] args) {
        System.out.println("Play and Work");

        testData.load();
    }
}