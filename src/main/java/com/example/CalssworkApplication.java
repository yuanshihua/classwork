package com.example;

import static java.lang.System.out;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.example.pojo.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CalssworkApplication {

	private static ObjectMapper mapper;
	
	@Autowired
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CalssworkApplication.class, args);
		int count = context.getBeanDefinitionCount();
		System.out.println("Beans的个数：" + count);
		Person me = new Person();
		me.setAge(18);
		me.setName("heheda");
		try {
			out.println(mapper.writeValueAsString(me));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		String json = "{\"name\":\"Daniel\",\"age\":22}";
		try {
			Person p2 = mapper.readValue(json, Person.class);
			out.println(p2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Bean
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}
}
