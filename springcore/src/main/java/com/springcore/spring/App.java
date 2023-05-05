package com.springcore.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/spring/config.xml");
        Student student = (Student) context.getBean("student");
        Student student1 = (Student) context.getBean("student1");
        System.out.println(student);
        System.out.println(student1);
    }
}


