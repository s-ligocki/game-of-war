package com.beleco.gameofwar.controller;

import com.beleco.gameofwar.Application;
import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.exception.NotValidBoardExcepiton;
import com.beleco.gameofwar.service.BoardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Everdark on 13.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BoardControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private BoardService boardService;

    @InjectMocks
    private BoardController controllerUnderTest;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();
    }

    @Test
    public void getInitialBoard() throws Exception {
        when(boardService.getNewGeneration(isA(Board.class))).thenReturn(new Board());
        mockMvc.perform(get("/get-new-board/")
                .contentType(contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void getInitialBoardBadInput() throws Exception {
        when(boardService.getNewGeneration(null)).thenThrow(NotValidBoardExcepiton.class);
        mockMvc.perform(get("/get-new-board/")
                .contentType(contentType))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNextBoard() throws Exception {
        when(boardService.getNewGeneration(isA(Board.class))).thenReturn(new Board());
        mockMvc.perform(post("/get-new-generation/")
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
