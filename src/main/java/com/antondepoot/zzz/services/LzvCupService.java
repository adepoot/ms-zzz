package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.TeamStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LzvCupService {

    private static final int POSITION_COLUMN = 0;
    private static final int NAME_COLUMN = 0;
    private static final int PLAYED_COLUMN = 1;
    private static final int WON_COLUMN = 2;
    private static final int DRAW_COLUMN = 3;
    private static final int LOST_COLUMN = 4;
    private static final int GOALS_FOR_COLUMN = 5;
    private static final int GOALS_AGAINST_COLUMN = 6;
    private static final int GOALS_DIFFERENCE_COLUMN = 7;
    private static final int POINTS_COLUMN = 8;
    private static final int POINTS_PER_MATCH = 9;

    private final String lzvcupBaseUrl;

    public LzvCupService(final AppProperties appProperties) {
        this.lzvcupBaseUrl = appProperties.getLzvcupBaseUrl();
    }

    public List<TeamStats> getCurrentStandings() {
        try {
            Document document = Jsoup.connect(lzvcupBaseUrl + "/results/6/31/2").get();

            List<Element> rows = Objects.requireNonNull(document.getElementById("tableAccordeon")).select("li");

            return rows.stream()
                    .skip(1) // Skip table header
                    .map(
                            element -> {
                                List<Element> rowElements = element.getElementsByClass("item-row").get(0).getElementsByClass("item-col");

                                String name = rowElements.get(NAME_COLUMN).select("a").text();
                                int position = Integer.parseInt(rowElements.get(POSITION_COLUMN).select("div > div > div").get(0).text());
                                int points = Integer.parseInt(rowElements.get(POINTS_COLUMN).text());
                                int matchesPlayed = Integer.parseInt(rowElements.get(PLAYED_COLUMN).text());
                                int matchesWon = Integer.parseInt(rowElements.get(WON_COLUMN).text());
                                int matchesDrawn = Integer.parseInt(rowElements.get(DRAW_COLUMN).text());
                                int matchesLost = Integer.parseInt(rowElements.get(LOST_COLUMN).text());
                                int goalsFor = Integer.parseInt(rowElements.get(GOALS_FOR_COLUMN).text());
                                int goalsAgainst = Integer.parseInt(rowElements.get(GOALS_AGAINST_COLUMN).text());
                                int goalsDifference = Integer.parseInt(rowElements.get(GOALS_DIFFERENCE_COLUMN).text());
                                double pointsPerMatch = Double.parseDouble(rowElements.get(POINTS_PER_MATCH).text());

                                return new TeamStats(name, position, points,
                                        matchesPlayed, matchesWon, matchesDrawn, matchesLost,
                                        goalsFor, goalsAgainst, goalsDifference,
                                        pointsPerMatch);
                            })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
