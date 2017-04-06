package neusoft.memcached.service;

import java.net.InetSocketAddress;
import java.util.Map;

public interface MemcachedService {
	public final static String MEMCACHED_ID = "com.neusoft.web.memcached.MEMCACHED_ID";
	public final static String HTML_NAME = "com.neusoft.web.memcached.HTML_NAME";
	public final static String USERINFO_NAME = "com.neusoft.web.memcached.USERINFO_NAME";
	public final static String AUTHDATA_NAME = "com.neusoft.web.memcached.AUTHDATA_NAME";

	void add(String key, Object value);

	void remove(String key);

	void remove(String[] keys);

	Object get(String key);

	Object[] get(String[] keys);

	void clear();

	void clear(String name);

	Map<InetSocketAddress, Map<String, String>> stat();

	Map<InetSocketAddress, Map<String, String>> stat(String name);

	void add(String name, String key, Object value);

	void remove(String name, String key);

	Object get(String name, String key);
}
