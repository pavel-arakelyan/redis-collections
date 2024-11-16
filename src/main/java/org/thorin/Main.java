package org.thorin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.thorin.collections.RedisMap;

import java.util.Map;

/**
 * @author pavel.arakelyan
 */
@SpringBootConfiguration
@ComponentScan(basePackages = "org.thorin")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		Map<String, Integer> map = new RedisMap("myMap");
		map.put("a",1);
		System.out.println("Voila: " + map.get("b"));
	}
}