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
		var key = "a";
		var value = 1;
		System.out.printf("Putting %s=%d into the map.%n", key, value);
		map.put(key, value);
		System.out.printf("Getting %s from the map: %d%n", key, map.get(key));
	}
}