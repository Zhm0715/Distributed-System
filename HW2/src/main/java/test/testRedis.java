package test;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class testRedis {

    @Test
    public void test1(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());
        jedis.set("Zhm", "Hello");
        System.out.println(jedis.get("Zhm"));
    }

}
