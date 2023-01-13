package com.varunsrini.cricbase.cricketdatabase.util;

import com.varunsrini.cricbase.cricketdatabase.business.CricBaseService;
import com.varunsrini.cricbase.cricketdatabase.entity.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final CricBaseService cricBaseService;

    public AppStartupEvent(CricBaseService cricBaseService) {
        this.cricBaseService = cricBaseService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
//        List<Tournament> tournaments = this.cricBaseService.getTournaments();
//        tournaments.forEach(System.out::println);
//
//        List<Match> matches = this.cricBaseService.getMatches();
//        matches.forEach(System.out::println);
//
//        List<Team> teams = this.cricBaseService.getTeams();
//        teams.forEach(System.out::println);

//        List<Player> players = this.cricBaseService.getPlayers();
//        players.forEach(System.out::println);
//
//        List<Dismissal> dismissals = this.cricBaseService.getDismissals();
//        dismissals.forEach(System.out::println);
//
//        List<BattingAnalysis> battingAnalyses = this.cricBaseService.getBattingAnalyses();
//        battingAnalyses.forEach(System.out::println);
//
//        List<BowlingAnalysis> bowlingAnalyses = this.cricBaseService.getBowlingAnalyses();
//        bowlingAnalyses.forEach(System.out::println);
//
//        List<FieldingAnalysis> fieldingAnalyses = this.cricBaseService.getFieldingAnalyses();
//        fieldingAnalyses.forEach(System.out::println);
    }
}
