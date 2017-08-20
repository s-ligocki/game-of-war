package com.beleco.gameofwar.redis.resource;

import com.beleco.gameofwar.redis.exception.ValueDoesNotExistsException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import redis.clients.jedis.Jedis;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Everdark on 20.08.2017.
 */
public class RedisResourceTest {

    RedisResource redisResource = new RedisResource();

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(redisResource, "jedis", new Jedis("localhost"));
    }

    @Test
    public void put() throws Exception {
        //GIVEN
        String testKey = "xxx";
        String testValue = "xxxValue";
        //WHEN
        redisResource.put(testKey, testValue);
        String redisTestValue = redisResource.get(testKey);
        //THEN
        assertTrue(redisTestValue!=null);
        assertTrue(testValue.equals(redisTestValue));

        //Finally
        redisResource.delete(testKey);
    }

    @Test(expected = ValueDoesNotExistsException.class)
    public void get() throws Exception {
        String testKey = "yyy";
        redisResource.get(testKey);
    }

    @Test
    public void delete() throws Exception {
        //GIVEN
        String testKey = "zzz";
        String testValue = "zzzValue";
        redisResource.put(testKey, testValue);
        //WHEN
        redisResource.delete(testKey);
        //THEN
        boolean isMissing = false;
        try{
            redisResource.get(testKey);
        }catch(ValueDoesNotExistsException e){
            isMissing = true;
        }
        assertTrue(isMissing);
    }

    @Test(expected = ValueDoesNotExistsException.class)
    public void deleteMissing() throws Exception {
        String testKey = "ooo";
        String testValue = "oooValue";
        redisResource.delete(testKey);
    }

    @Test
    public void exists() throws Exception {
        //GIVEN
        String testKey = "aaa";
        String testValue = "aaaValue";
        String testMissing = "ccc";
        //WHEN
        redisResource.put(testKey, testValue);
        //THEN
        assertTrue(redisResource.exists(testKey));
        assertFalse(redisResource.exists(testMissing));

        //Finally
        redisResource.delete(testKey);
    }
}