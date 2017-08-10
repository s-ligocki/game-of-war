package com.beleco.gameofwar.rest.controller;

import com.beleco.gameofwar.core.domain.*;
import com.beleco.gameofwar.rest.Application;
import com.beleco.gameofwar.rest.service.GameService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Everdark on 13.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class GameControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private GameService gameService;

    @InjectMocks
    private GameController controllerUnderTest;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();
    }

    @Test
    public void login() throws Exception {
        when(gameService.login(isA(String.class))).thenReturn(new UserID("TEST_USER_ID"));
        mockMvc.perform(get("/login/username")
                .contentType(contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void reset() throws Exception {
        mockMvc.perform(get("/reset/user-id")
                .contentType(contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void getGameState() throws Exception {
        when(gameService.getGameState(isA(String.class))).thenReturn(new GameState(GameState.GameStateEnumerable.YOUR_TURN));
        mockMvc.perform(get("/get-game-state/userid")
                .contentType(contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void getBoard() throws Exception {
        when(gameService.getBoardState(isA(String.class))).thenReturn(new Board());
        mockMvc.perform(get("/get-board/userid")
                .contentType(contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void play() throws Exception {
        mockMvc.perform(post("/play/userid")
                .content("{\n" +
                        "  \"state\": [\n" +
                        "    [\n" +
                        "      \"PLAYER_TWO\",\n" +
                        "      \"PLAYER_TWO\",\n" +
                        "      \"PLAYER_ONE\"\n" +
                        "    ],\n" +
                        "    [\n" +
                        "      \"EMPTY\",\n" +
                        "      \"PLAYER_TWO\",\n" +
                        "      \"PLAYER_ONE\"\n" +
                        "    ],\n" +
                        "    [\n" +
                        "      \"EMPTY\",\n" +
                        "      \"EMPTY\",\n" +
                        "      \"EMPTY\"\n" +
                        "    ]\n" +
                        "  ],\n" +
                        "  \"size\": 3,\n" +
                        "  \"ownerId\": 0\n" +
                        "}")
                .contentType(contentType))
                .andExpect(status().isOk());
    }
}
