package com.antondepoot.zzz.web;

import com.antondepoot.zzz.services.GameService;
import com.antondepoot.zzz.web.responses.GameResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameResource {

    final GameService gameService;

    public GameResource(final GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping()
    public List<GameResponse> getGames() {
        return this.gameService.getGames().stream()
                .map(GameResponse::from).toList();
    }

}
