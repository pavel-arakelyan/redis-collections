package org.thorin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.thorin.collections.RedisMap;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * NOTE! Needs an up and running redis server to run
 *
 * @author pavel.arakelyan
 */
@SpringBootTest
class MainTest {

	private Map<String, Integer> map;

	@BeforeEach
	void beforeEach() {
		map = new RedisMap("testMap");
	}

	@AfterEach
	void tearDown() {
		map.clear();
	}

	@Test
	void get() {
		map.put("a", 1);
		assertThat(map.get("a")).isEqualTo(1);
	}

	@Test
	void size() {
		map.put("a", 1);
		assertThat(map).hasSize(1);
	}

	@Test
	void isEmpty() {
		assertThat(map).isEmpty();
	}

	@Test
	void containsKey() {
		map.put("a", 1);
		assertThat(map).containsKey("a");
	}

	@Test
	void containsValue() {
		map.put("a", 1);
		assertThat(map).containsValue(1);
	}

	@Test
	void remove() {
		map.put("a", 1);
		map.remove("a");
		assertThat(map).doesNotContainKey("a");
	}

	@Test
	void putAll() {
		map.putAll(Map.of("a", 1, "b", 2));
		assertThat(map).containsEntry("a", 1).containsEntry("b", 2);
	}

	@Test
	void keySet() {
		map.putAll(Map.of("a", 1, "b", 2));
		assertThat(map.keySet()).containsExactlyInAnyOrder("a", "b");
	}

	@Test
	void values() {
		map.putAll(Map.of("a", 1, "b", 2));
		assertThat(map.values()).containsExactlyInAnyOrder(1, 2);
	}

	@Test
	void entrySet() {
		map.putAll(Map.of("a", 1, "b", 2));
		assertThat(map.entrySet()).containsExactlyInAnyOrder(
				Map.entry("a", 1),
				Map.entry("b", 2)
		);
	}

}