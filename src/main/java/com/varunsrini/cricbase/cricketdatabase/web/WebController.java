package com.varunsrini.cricbase.cricketdatabase.web;

import com.varunsrini.cricbase.cricketdatabase.business.CricBaseService;
import com.varunsrini.cricbase.cricketdatabase.entity.data.*;
import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.AnalysisId;
import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.DismissalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WebController {

    @Autowired
    private CricBaseService cricBaseService;

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<>(this.cricBaseService.getPlayers(), HttpStatus.OK);
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") long playerId){
        Optional<Player> playerOptional = this.cricBaseService.getPlayer(playerId);
        if(playerOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playerOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/player")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player savedPlayer = this.cricBaseService.addPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable("id") long playerId){
        Optional<Player> player = this.cricBaseService.getPlayer(playerId);
        if(player.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cricBaseService.deletePlayer(player.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/tournaments")
    public ResponseEntity<List<Tournament>> getAllTournaments(){
        return new ResponseEntity<>(this.cricBaseService.getTournaments(), HttpStatus.OK);
    }

    @GetMapping("/tournament/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable("id") long tournamentId){
        Optional<Tournament> tournamentOptional = this.cricBaseService.getTournamentById(tournamentId);
        if(tournamentOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tournamentOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/tournament")
    public ResponseEntity<Tournament> addTournament(@RequestBody Tournament tournament){
        Tournament savedTournament = this.cricBaseService.addTournament(tournament);
        return new ResponseEntity<>(savedTournament, HttpStatus.CREATED);
    }

    @DeleteMapping("/tournament/{id}")
    public ResponseEntity<Void> deleteTournamentById(@PathVariable("id") long tournamentId){
        Optional<Tournament> tournament = this.cricBaseService.getTournamentById(tournamentId);
        if(tournament.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cricBaseService.deleteTournament(tournament.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAllTeams(){
        return new ResponseEntity<>(this.cricBaseService.getTeams(), HttpStatus.OK);
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") long teamId){
        Optional<Team> teamOptional = this.cricBaseService.getTeamById(teamId);
        if(teamOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teamOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/team")
    public ResponseEntity<Team> addTeam(@RequestBody Team team){
        Team savedTeam = this.cricBaseService.addTeam(team);
        return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
    }

    @DeleteMapping("/team/{id}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable("id") long teamId){
        Optional<Team> teamOptional = this.cricBaseService.getTeamById(teamId);
        if(teamOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cricBaseService.deleteTeam(teamOptional.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/matches")
    public ResponseEntity<List<Match>> getAllMatches(){
        return new ResponseEntity<>(this.cricBaseService.getMatches(), HttpStatus.OK);
    }

    @GetMapping("/match/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable("id") long matchId){
        Optional<Match> matchOptional = this.cricBaseService.getMatchById(matchId);
        if(matchOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(matchOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/match")
    public ResponseEntity<Match> addMatch(@RequestBody Match match){
        Match savedMatch = this.cricBaseService.addMatch(match);
        return new ResponseEntity<>(savedMatch, HttpStatus.CREATED);
    }

    @DeleteMapping("/match/{id}")
    public ResponseEntity<Void> deleteMatchById(@PathVariable("id") long matchId){
        Optional<Match> match = this.cricBaseService.getMatchById(matchId);
        if(match.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cricBaseService.deleteMatch(match.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/dismissals")
    public ResponseEntity<List<Dismissal>> getAlLDismissals(){
        return new ResponseEntity<>(this.cricBaseService.getDismissals(), HttpStatus.OK);
    }

    @GetMapping("/dismissal/{matchId}/{batterId}")
    public ResponseEntity<Dismissal> getDismissalById(@PathVariable("matchId") long matchId, @PathVariable("batterId") long batterId){
        DismissalId dismissalId = new DismissalId(matchId, batterId);
        Optional<Dismissal> dismissalOptional = this.cricBaseService.getDismissalById(dismissalId);
        if(dismissalOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dismissalOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/dismissal")
    public ResponseEntity<Dismissal> addDismissal(@RequestBody Dismissal dismissal){
        Dismissal savedDismissal = this.cricBaseService.addDismissal(dismissal);
        return new ResponseEntity<>(savedDismissal, HttpStatus.CREATED);
    }

    @DeleteMapping("/dismissal/{matchId}/{batterId}")
    public ResponseEntity<Void> deleteDismissalById(@PathVariable("matchId") long matchId, @PathVariable("batterId") long batterId){
        DismissalId dismissalId = new DismissalId(matchId, batterId);
        Optional<Dismissal> dismissalOptional = this.cricBaseService.getDismissalById(dismissalId);
        if(dismissalOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cricBaseService.deleteDismissal(dismissalOptional.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/battingAnalyses")
    public ResponseEntity<List<BattingAnalysis>> getAllBattingAnalyses(){
        return new ResponseEntity<>(this.cricBaseService.getBattingAnalyses(), HttpStatus.OK);
    }

    @GetMapping("/battingAnalysis/{playerId}/{matchId}/{teamId}")
    public ResponseEntity<BattingAnalysis> getBattingAnalysisById(@PathVariable("playerId") long playerId, @PathVariable("matchId") long matchId, @PathVariable("teamId") long teamId){
        AnalysisId analysisId = new AnalysisId(playerId, matchId, teamId);
        Optional<BattingAnalysis> battingAnalysisOptional = this.cricBaseService.getBattingAnalysisByAnalysisId(analysisId);
        if(battingAnalysisOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(battingAnalysisOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/battingAnalysis")
    public ResponseEntity<BattingAnalysis> addBattingAnalysis(@RequestBody BattingAnalysis battingAnalysis){
        BattingAnalysis savedBattingAnalysis = this.cricBaseService.addBattingAnalysis(battingAnalysis);
        return new ResponseEntity<>(savedBattingAnalysis, HttpStatus.CREATED);
    }

    @DeleteMapping("/battingAnalysis/{playerId}/{matchId}/{teamId}")
    public ResponseEntity<Void> deleteBattingAnalysisById(@PathVariable("playerId") long playerId, @PathVariable("matchId") long matchId, @PathVariable("teamId") long teamId){
        AnalysisId analysisId = new AnalysisId(playerId, matchId, teamId);
        Optional<BattingAnalysis> battingAnalysis = this.cricBaseService.getBattingAnalysisByAnalysisId(analysisId);
        if(battingAnalysis.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cricBaseService.deleteBattingAnalysis(battingAnalysis.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/bowlingAnalyses")
    public ResponseEntity<List<BowlingAnalysis>> getAllBowlingAnalyses(){
        return new ResponseEntity<>(this.cricBaseService.getBowlingAnalyses(), HttpStatus.OK);
    }

    @GetMapping("bowlingAnalysis/{playerId}/{matchId}/{teamId}")
    public ResponseEntity<BowlingAnalysis> getBowlingAnalysisById(@PathVariable("playerId") long playerId, @PathVariable("matchId") long matchId, @PathVariable("teamId") long teamId){
        AnalysisId analysisId = new AnalysisId(playerId, matchId, teamId);
        Optional<BowlingAnalysis> bowlingAnalysisOptional = this.cricBaseService.getBowlingAnalysisByAnalysisId(analysisId);
        if(bowlingAnalysisOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bowlingAnalysisOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/bowlingAnalysis")
    public ResponseEntity<BowlingAnalysis> addBowlingAnalysis(@RequestBody BowlingAnalysis bowlingAnalysis){
        BowlingAnalysis savedBowlingAnalysis = this.cricBaseService.addBowlingAnalysis(bowlingAnalysis);
        return new ResponseEntity<>(savedBowlingAnalysis, HttpStatus.CREATED);
    }

    @DeleteMapping("/bowlingAnalysis/{playerId}/{matchId}/{teamId}")
    public ResponseEntity<Void> deleteBowlingAnalysisById(@PathVariable("playerId") long playerId, @PathVariable("matchId") long matchId, @PathVariable("teamId") long teamId){
        AnalysisId analysisId = new AnalysisId(playerId, matchId, teamId);
        Optional<BowlingAnalysis> bowlingAnalysis = this.cricBaseService.getBowlingAnalysisByAnalysisId(analysisId);
        if(bowlingAnalysis.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cricBaseService.deleteBowlingAnalysis(bowlingAnalysis.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/fieldingAnalyses")
    public ResponseEntity<List<FieldingAnalysis>> getAllFieldingAnalyses(){
        return new ResponseEntity<>(this.cricBaseService.getFieldingAnalyses(), HttpStatus.OK);
    }

    @GetMapping("/fieldingAnalysis/{playerId}/{matchId}/{teamId}")
    public ResponseEntity<FieldingAnalysis> getFieldingAnalysisById(@PathVariable("playerId") long playerId, @PathVariable("matchId") long matchId, @PathVariable("teamId") long teamId){
        AnalysisId analysisId = new AnalysisId(playerId, matchId, teamId);
        Optional<FieldingAnalysis> fieldingAnalysisOptional = this.cricBaseService.getFieldingAnalysisByAnalysisId(analysisId);
        if(fieldingAnalysisOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fieldingAnalysisOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/fieldingAnalysis")
    public ResponseEntity<FieldingAnalysis> addFieldingAnalysis(@RequestBody FieldingAnalysis fieldingAnalysis){
        FieldingAnalysis savedFieldingAnalysis = this.cricBaseService.addFieldingAnalysis(fieldingAnalysis);
        return new ResponseEntity<>(savedFieldingAnalysis, HttpStatus.CREATED);
    }

    @DeleteMapping("/fieldingAnalysis/{playerId}/{matchId}/{teamId}")
    public ResponseEntity<Void> deleteFieldingAnalysisById(@PathVariable("playerId") long playerId, @PathVariable("matchId") long matchId, @PathVariable("teamId") long teamId){
        AnalysisId analysisId = new AnalysisId(playerId, matchId, teamId);
        Optional<FieldingAnalysis> fieldingAnalysis = this.cricBaseService.getFieldingAnalysisByAnalysisId(analysisId);
        if(fieldingAnalysis.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cricBaseService.deleteFieldingAnalysis(fieldingAnalysis.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/playerBowlingSummary/{playerId}")
    public ResponseEntity<PlayerBowlingSummary> getPlayerBowlingSummaryById(@PathVariable("playerId") long playerId){
        Optional<PlayerBowlingSummary> playerBowlingSummaryOptional = this.cricBaseService.getPlayerBowlingSummary(playerId);
        if(playerBowlingSummaryOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<PlayerBowlingSummary>(playerBowlingSummaryOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/playerBattingSummary/{playerId}")
    public ResponseEntity<PlayerBattingSummary> getPlayerBattingSummaryById(@PathVariable("playerId") long playerId){
        Optional<PlayerBattingSummary> playerBattingSummaryOptional = this.cricBaseService.getPlayerBattingSummary(playerId);
        if(playerBattingSummaryOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(playerBattingSummaryOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/playerFieldingSummary/{playerId}")
    public ResponseEntity<PlayerFieldingSummary> getPlayerFieldingSummaryById(@PathVariable("playerId") long playerId){
        Optional<PlayerFieldingSummary> playerFieldingSummaryOptional = this.cricBaseService.getPlayerFieldingSummary(playerId);
        if(playerFieldingSummaryOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(playerFieldingSummaryOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/playerSummary/{playerId}")
    public ResponseEntity<PlayerSummary> getPlayerSummaryById(@PathVariable("playerId") long playerId){
        Optional<PlayerSummary> playerSummaryOptional = this.cricBaseService.getPlayerSummaryById(playerId);
        if(playerSummaryOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(playerSummaryOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/playerSummary/team/{teamId}")
    public ResponseEntity<List<PlayerSummary>> getAllPlayerSummaryByTeamId(@PathVariable("teamId") long teamId){
        return new ResponseEntity<>(this.cricBaseService.getPlayerSummaryByTeamId(teamId), HttpStatus.OK);
    }

}
