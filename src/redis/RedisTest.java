import redis.clients.jedis.Jedis;

/**
 * @author
 */

public class RedisTest {

    public static void main(String[] args) {
        ClaRedis();
    }

    public static void ClaRedis() {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        for (int i = 0; i < 100; i++) {
            jedis.select(1);
            jedis.lpush("key" + i, "name" + i);
        }
        jedis.close();
    }

}
