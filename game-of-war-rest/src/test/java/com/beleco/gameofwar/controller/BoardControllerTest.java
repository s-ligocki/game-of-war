package com.beleco.gameofwar.controller;

import com.beleco.gameofwar.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;

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

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getInitialBoard() throws Exception {
        mockMvc.perform(get("/get-new-board/")
                .contentType(contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void getNextBoard() throws Exception {
        mockMvc.perform(post("/get-new-generation/")
                .content("{\n" +
                        "  \"state\": [\n" +
                        "    [\n" +
                        "      {\n" +
                        "        \"stateOfLife\": \"WHITE\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"stateOfLife\": \"BLACK\"\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    [\n" +
                        "      {\n" +
                        "        \"stateOfLife\": \"WHITE\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"stateOfLife\": \"EMPTY\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"stateOfLife\": \"EMPTY\"\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    [\n" +
                        "      {\n" +
                        "        \"stateOfLife\": \"WHITE\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"stateOfLife\": \"BLACK\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"stateOfLife\": \"BLACK\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  ],\n" +
                        "  \"size\": 3,\n" +
                        "  \"ownerId\": 0\n" +
                        "}")
                .contentType(contentType))
                .andExpect(status().isOk());
    }
}
