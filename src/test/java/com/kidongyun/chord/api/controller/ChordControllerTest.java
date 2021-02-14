package com.kidongyun.chord.api.controller;

import com.kidongyun.chord.api.domain.Note;
import com.kidongyun.chord.api.service.ChordService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ChordController.class)
public class ChordControllerTest {
    @MockBean
    private ChordService chordService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getChord_when_then() throws Exception {
        /* Arrange */
        when(chordService.findBase(anyList())).thenReturn(Optional.ofNullable(Note.of("C1")));

        /* Act */
        String result = mockMvc.perform(get("/api/v1/chord")
                .param("notes", "C1,E1,G1")
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        /* Assert */
        log.info("YKD : " + result);
    }
}