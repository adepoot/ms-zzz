package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.PlayerRepository;
import com.antondepoot.zzz.domain.entities.Player;
import com.antondepoot.zzz.domain.entities.Season;
import com.antondepoot.zzz.domain.exceptions.PlayerNotFound;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private static final Season CURRENT_SEASON = Season.SEASON_2021_2022;

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    public Player getPlayer(final UUID id) {
        Player player = this.playerRepository.findById(id).orElseThrow(() -> new PlayerNotFound(id));

        filterOnCurrentSeason(player);

        return player;
    }

    @Transactional
    public List<Player> getPlayers() {
        List<Player> players = this.playerRepository.findAll();

        players.forEach(this::filterOnCurrentSeason);

        return players;
    }

    private void filterOnCurrentSeason(Player player) {
        player.setGames(player.getGames().stream()
                .filter(
                        game -> game.getDate().isBefore(CURRENT_SEASON.getEnd()) &&
                                game.getDate().isAfter(CURRENT_SEASON.getStart()))
                .collect(Collectors.toSet()));

        player.setGoals(player.getGoals().stream()
                .filter(
                        goal -> goal.getGame().getDate().isBefore(CURRENT_SEASON.getEnd()) &&
                                goal.getGame().getDate().isAfter(CURRENT_SEASON.getStart()))
                .collect(Collectors.toList()));

        player.setAssists(player.getAssists().stream()
                .filter(
                        assist -> assist.getGame().getDate().isBefore(CURRENT_SEASON.getEnd()) &&
                                assist.getGame().getDate().isAfter(CURRENT_SEASON.getStart()))
                .collect(Collectors.toList()));

        player.setSaves(player.getSaves().stream()
                .filter(
                        save -> save.getGame().getDate().isBefore(CURRENT_SEASON.getEnd()) &&
                                save.getGame().getDate().isAfter(CURRENT_SEASON.getStart()))
                .collect(Collectors.toList()));

    }

}
