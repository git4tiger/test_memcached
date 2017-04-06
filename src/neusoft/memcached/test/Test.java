package neusoft.memcached.test;

import net.rubyeye.xmemcached.MemcachedClient;
import neusoft.memcached.client.MemcachedClientBuilder;
import neusoft.memcached.service.MemcachedService;
import neusoft.memcached.service.impl.MemcachedServiceImpl;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MemcachedClientBuilder clientBuilder=new MemcachedClientBuilder("userinfo");
		MemcachedClient client=clientBuilder.build();
		
		MemcachedService ms=new MemcachedServiceImpl(client);
		//ms.add("myName","Â¬ÒæÖ¾");
		
		System.out.println(ms.get("myName"));
		client.shutdown();
	}

}
