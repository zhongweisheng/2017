import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

public class RedisJsonStringJava {
	public static void main(String[] args) {
		// Connecting to Redis server on localhost
		// Jedis jedis = new Jedis("localhost");
		// Jedis jedis = new Jedis("192.168.1.49", 6379);
		Jedis jedis = new Jedis("192.168.1.49", 6379, 2000);
		jedis.auth("123qwe!@#");

		System.out.println("Connection to server sucessfully");
		// set the data in redis string
		// jedis.set("tutorial-name", "Redis tutorial");

		Topic topic = new Topic();
		topic.setId(90);
		topic.setName("花好月圆");
		JSONObject obj = new JSONObject();
		jedis.set("tutorial-name", JSONObject.fromObject(topic).toString());
		// Get the stored data and print it
		System.out.println("Stored string in redis:: " + jedis.get("tutorial-name").toString());
		Topic t = (Topic) JSONObject.toBean(JSONObject.fromObject(jedis.get("tutorial-name").toString()), Topic.class);
		System.out.println(JSONObject.fromObject(t).toString());
	}
}