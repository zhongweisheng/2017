package com.my.test.redis;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import org.redisson.Config;
import org.redisson.Redisson;

public class RedisExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1.初始化
		Config config = new Config();
		config.setConnectionPoolSize(10);
		// config.addAddress("127.0.0.1:6379");
		// config.addAddress("192.168.199.224:6379");
		config.addAddress("192.168.1.49:6379");
		config.setPassword("123qwe!@#");
		Redisson redisson = Redisson.create(config);
		System.out.println("reids连接成功...");

		// 2.测试concurrentMap,put方法的时候就会同步到redis中
		ConcurrentMap<String, Object> map = redisson.getMap("FirstMap");
		map.put("wuguowei", "男");
		map.put("zhangsan", "nan");
		map.put("lisi", "女");

		ConcurrentMap resultMap = redisson.getMap("FirstMap");
		System.out.println("resultMap==" + resultMap.keySet());

		// 2.测试Set集合
		// Set mySet = redisson.getSet("MySet");
		// mySet.add("wuguowei");
		// mySet.add("lisi");

		Set resultSet = redisson.getSet("MySet");
		System.out.println("resultSet===" + resultSet.size());

		// 3.测试Queue队列
		Queue myQueue = redisson.getQueue("FirstQueue");
		// myQueue.add("wuguowei");
		// myQueue.add("lili");
		// myQueue.add("zhangsan");
		myQueue.peek();
		myQueue.poll();

		Queue resultQueue = redisson.getQueue("FirstQueue");
		System.out.println("resultQueue===" + resultQueue);

		// 关闭连接

		Set name = redisson.getSet("name");
		// name.add("1111");
		System.out.println(name.toString());

		if (name != null) {

			Object[] mm = name.toArray();
			for (Object o : mm) {
				System.out.println(o.toString());
			}
		}

		redisson.shutdown();
	}

}