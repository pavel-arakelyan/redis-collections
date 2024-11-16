package org.thorin.collections;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.thorin.config.ApplicationContextProvider;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author pavel.arakelyan
 */
public class RedisMap implements Map<String, Integer> {

	private final RMap<String, Integer> delegate;

	public RedisMap(String name) {
		var redissonClient = ApplicationContextProvider.getApplicationContext().getBean(RedissonClient.class);
		delegate = redissonClient.getMap(name);
	}

	@Override
	public int size() {
		return delegate.size();
	}

	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return delegate.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return delegate.containsValue(value);
	}

	@Override
	public Integer get(Object key) {
		return delegate.get(key);
	}

	@Override
	public Integer put(String key, Integer value) {
		return delegate.put(key, value);
	}

	@Override
	public Integer remove(Object key) {
		return delegate.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Integer> m) {
		delegate.putAll(m);
	}

	@Override
	public void clear() {
		delegate.clear();
	}

	@Override
	public Set<String> keySet() {
		return delegate.keySet();
	}

	@Override
	public Collection<Integer> values() {
		return delegate.values();
	}

	@Override
	public Set<Entry<String, Integer>> entrySet() {
		return delegate.entrySet();
	}
}
