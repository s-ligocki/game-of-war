package com.beleco.gameofwar.rest.service;

import com.beleco.gameofwar.domain.domain.UserID;
import com.beleco.gameofwar.rest.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by Everdark on 19.08.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SimpleGameServiceTest {

    @Autowired
    SimpleGameService simpleGameServiceInstance;

    @Test
    public void login() throws Exception {
        //GIVEN
        String username1 = "Batman";
        String username2 = "Robin";
        String username3 = "Flash";
        //WHEN
        UserID userid1 = simpleGameServiceInstance.login(username1);
        UserID userid2 = simpleGameServiceInstance.login(username2);
        UserID userid3 = simpleGameServiceInstance.login(username3);
        //THEN
        assertTrue(userid1 != null);
        assertFalse(userid3.getUserID().equals(userid2.getUserID()));
    }

    @Test
    public void reLogin() throws Exception {
        //GIVEN
        String username = "Adam";
        //WHEN
        UserID useridPre = simpleGameServiceInstance.login(username);
        UserID useridPost = simpleGameServiceInstance.login(username);
        //THEN
        assertTrue(useridPre.getUserID().equals(useridPost.getUserID()));
    }

    @Test
    public void reset() throws Exception {
    }

    @Test
    public void getGameState() throws Exception {
    }

    @Test
    public void getBoardState() throws Exception {
    }

    @Test
    public void play() throws Exception {
    }

}