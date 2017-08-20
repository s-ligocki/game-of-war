package com.beleco.gameofwar.redis.service;

import com.beleco.gameofwar.domain.domain.User;
import com.beleco.gameofwar.domain.domain.UserID;
import com.beleco.gameofwar.redis.resource.RedisResource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

/**
 * Created by Everdark on 20.08.2017.
 */
public class SimpleLoginServiceTest {

    @InjectMocks
    SimpleLoginService simpleLoginService;

    @Mock
    RedisResource redisResource;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);


    }

    @Test
    public void userExists() throws Exception {
        //GIVEN
        Mockito.when(redisResource.exists(any(String.class))).thenReturn(Boolean.TRUE);
        //WHEN
        boolean test = simpleLoginService.userExists("xxx");
        //THEN
        assertTrue(test);
    }

    @Test
    public void userExists1() throws Exception {
        //GIVEN
        Mockito.when(redisResource.exists(any(String.class))).thenReturn(Boolean.FALSE);
        //WHEN
        boolean test = simpleLoginService.userExists("xxx");
        //THEN
        assertFalse(test);
    }

    @Test
    public void getUserIdByUsername() throws Exception {
        //GIVEN
        String testUserID = "xxx_id";
        Mockito.when(redisResource.get(any(String.class))).thenReturn(testUserID);
        //WHEN
        UserID userID = simpleLoginService.getUserIdByUsername("xxx");
        //THEN
        assertTrue(userID.getUserID().equals(testUserID));
    }

    @Test
    public void getUserById() throws Exception {
        //GIVEN
        UserID testUserID = new UserID("yyy_id");
        String testUsername = "yyy";
        Mockito.when(redisResource.get(any(String.class))).thenReturn(testUsername);
        //WHEN
        User user = simpleLoginService.getUserById(testUserID);
        //THEN
        assertTrue(user.getUsername().equals(testUsername));
        assertTrue(user.getUserID().equals(testUserID));
    }
}