package com.beleco.gameofwar.redis.resource;

import com.beleco.gameofwar.redis.exception.ValueDoesNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * Created by Everdark on 20.08.2017.
 */
@Component
public class RedisResource {

    @Autowired
    private Jedis jedis;

    public boolean exists(String key){
        String value = jedis.get(key);
        if(value!=null){
            return true;
        }
        return false;
    }

    public String get(String key) throws ValueDoesNotExistsException {
        String value = jedis.get(key);
        if(value==null){
            throw new ValueDoesNotExistsException("Value " + value + " was not found in Redis");
        }
        return value;
    }

    public void put(String key, String value){
        jedis.set(key, value);
    }

    public void delete(String key) throws ValueDoesNotExistsException {
        String value = jedis.get(key);
        if(value==null){
            throw new ValueDoesNotExistsException("Value " + value + " was not found in Redis");
        }
        jedis.del(key);
    }
}
