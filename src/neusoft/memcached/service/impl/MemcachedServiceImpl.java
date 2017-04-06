package neusoft.memcached.service.impl;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import neusoft.memcached.service.MemcachedService;

public class MemcachedServiceImpl implements MemcachedService{
	private MemcachedClient memCachedClient;

	
	public MemcachedServiceImpl(MemcachedClient client){
		memCachedClient=client;
	}
	
	public void remove(String key) {
		try {
			memCachedClient.delete(key);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

	public void clear() {
		try {
			memCachedClient.flushAll();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

	public void clear(String name) {
		try {
			memCachedClient.flushAll();
			
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

	public void add(String key, Object value) {
		try {
			memCachedClient.set( key, 0, value);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}
	public Map<InetSocketAddress, Map<String, String>> stat() {
		try {
			return memCachedClient.getStats();
		} catch (MemcachedException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<InetSocketAddress, Map<String, String>> stat(String name) {
		try {
			return memCachedClient.getStats();
			
		} catch (MemcachedException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object get(String key) {
		Object o = null;
		try {
			o = memCachedClient.get(key);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public void remove(String[] keys) {
		try {
			for (final String key : keys) {
				memCachedClient.delete(key);
			}
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

	public Object[] get(String[] keys) {
		final List<Object> values = new ArrayList<Object>();
		try {
			for (final String key : keys) {
				values.add(memCachedClient.get(key));
			}
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		return values.toArray();
	}

	public void add(String name, String key, Object value) {
		add(key, value);
	}

	public void remove(String name, String key) {
		remove(key);

	}

	public Object get(String name, String key) {
		return get(key);
			
	}

	public MemcachedClient getMemCachedClient() {
		return memCachedClient;
	}

}
