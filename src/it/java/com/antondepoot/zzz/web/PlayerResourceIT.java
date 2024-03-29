package com.antondepoot.zzz.web;

import com.antondepoot.zzz.domain.exceptions.PlayerNotFound;
import com.antondepoot.zzz.services.PlayerService;
import com.antondepoot.zzz.services.StatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static com.antondepoot.zzz.TestData.aPlayer;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTest(resources = {PlayerResource.class})
class PlayerResourceIT {

    @MockBean
    private PlayerService playerService;

    @MockBean
    private StatisticsService statisticsService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void returns_player_info_for_valid_request() throws Exception {
        var expected = aPlayer();
        when(this.playerService.getPlayer(expected.id())).thenReturn(expected);

        this.mockMvc.perform(get("/players/{id}/info", expected.id()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(expected.id().toString())))
                .andExpect(jsonPath("$.first_name", is(expected.firstName())))
                .andExpect(jsonPath("$.last_name", is(expected.lastName())));
    }

    @Test
    void returns_404_when_player_info_not_found() throws Exception {
        when(this.playerService.getPlayer(any())).thenThrow(PlayerNotFound.class);

        this.mockMvc.perform(get("/players/{id}/info", UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }

}
