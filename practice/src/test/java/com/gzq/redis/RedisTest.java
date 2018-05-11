package com.gzq.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {
    
    @Test
    public void testHello() {
        Jedis redis = new Jedis("192.168.40.144");
        String ping = redis.ping();
        System.out.println(ping);
    }
    
    /**
     * 保存字符串格式数据
     */
    @Test
    public void testString() {
        Jedis jedis = new Jedis("192.168.40.144");
        String set = jedis.set("mykey", "stringValue");
        System.out.println(set);
        String string = jedis.get("mykey");
        System.out.println(string);
    }
    
    
    

}
