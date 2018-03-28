package com.liujunbo.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {

		Map<String,String> map = new HashMap<>();
		map.put("1","11");
		map.put("2","22");
		map.put("3","33");
		map.put("4","44");
		map.forEach((key,value)->System.out.println("key:"+key+" value:"+value));


	}

}
