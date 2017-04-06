package neusoft.memcached.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class MemcachedClientBuilder extends net.rubyeye.xmemcached.XMemcachedClientBuilder {

	private final static String config = "/memcached.properties";
	
	public MemcachedClientBuilder(String type) {
		super(getAddress(type), new int[] {1});
	}
	
	private static List<InetSocketAddress> getAddress(String type) {
		Properties properties = new Properties();
		String ips = null;
		try {
			properties.load(MemcachedClientBuilder.class.getResourceAsStream(config));
			switch(type) {
			case "html" : 
				ips =  String.valueOf(properties.get("memcached.html"));
				break;
			case "userinfo" :
				ips =  String.valueOf(properties.get("memcached.userinfo"));
				break;
			case "authdata" :
				ips =  String.valueOf(properties.get("memcached.authdata"));
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert(ips != null && !"".equals(ips));
		return analysisIp(ips);
	}
	
	private static List<InetSocketAddress> analysisIp(String ips) {
		String[] ip = ips.split(",");
		List<InetSocketAddress> list = new ArrayList<InetSocketAddress>(ip.length);
		for(String i : ip) {
			String[] p = i.split(":");
			assert(p.length == 2);
			list.add(new InetSocketAddress(p[0], Integer.valueOf(p[1])));
		}
		return list;
	}
}
