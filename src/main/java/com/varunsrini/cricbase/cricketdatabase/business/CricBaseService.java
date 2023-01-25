package com.varunsrini.cricbase.cricketdatabase.business;

import com.varunsrini.cricbase.cricketdatabase.entity.data.*;
import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.AnalysisId;
import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.DismissalId;
import com.varunsrini.cricbase.cricketdatabase.entity.repository.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CricBaseService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final FieldingAnalysisRepository fieldingAnalysisRepository;
    private final BattingAnalysisRepository battingAnalysisRepository;
    private final BowlingAnalysisRepository bowlingAnalysisRepository;
    private final TournamentRepository tournamentRepository;
    private final MatchRepository matchRepository;
    private final DismissalRepository dismissalRepository;

    private final PlayerBowlingSummaryRepository playerBowlingSummaryRepository;

    private final PlayerBattingSummaryRepository playerBattingSummaryRepository;

    private final PlayerFieldingSummaryRepository playerFieldingSummaryRepository;

    public List<Player> getPlayers(){
        Iterable<Player> players = this.playerRepository.findAll();
        List<Player> playerList = new ArrayList<>();
        players.forEach(player -> playerList.add(player));
        return playerList;
    }

    public Optional<Player> getPlayer(long playerId){
        return this.playerRepository.findById(playerId);
    }

    public Player addPlayer(Player player){
        return this.playerRepository.save(player);
    }

    public void deletePlayer(Player player){
        this.playerRepository.delete(player);
    }

    public List<Team> getTeams(){
        Iterable<Team> teams = this.teamRepository.findAll();
        List<Team> teamList = new ArrayList<>();
        teams.forEach(team -> teamList.add(team));
        return teamList;
    }

    public Optional<Team> getTeamById(long teamId){
        return this.teamRepository.findById(teamId);
    }

    public Team addTeam(Team team){
        return this.teamRepository.save(team);
    }

    public void deleteTeam(Team team){
        this.teamRepository.delete(team);
    }
    public List<Tournament> getTournaments(){
        Iterable<Tournament> tournaments = this.tournamentRepository.findAll();
        List<Tournament> tournamentList = new ArrayList<>();
        tournaments.forEach(tournament -> tournamentList.add(tournament));
        return tournamentList;
    }

    public Optional<Tournament> getTournamentById(long tournamentId){
        return this.tournamentRepository.findById(tournamentId);
    }

    public Tournament addTournament(Tournament tournament) {
        return this.tournamentRepository.save(tournament);
    }

    public void deleteTournament(Tournament tournament) {
        this.tournamentRepository.delete(tournament);
    }

    public List<Match> getMatches(){
        Iterable<Match> matches = this.matchRepository.findAll();
        List<Match> matchList = new ArrayList<>();
        matches.forEach(match1 -> matchList.add(match1));
        return matchList;
    }

    public Optional<Match> getMatchById(long matchId){
        return this.matchRepository.findById(matchId);
    }

    public Match addMatch(Match match){
        return this.matchRepository.save(match);
    }

    public void deleteMatch(Match match){
        this.matchRepository.delete(match);
    }

    public List<Dismissal> getDismissals(){
        Iterable<Dismissal> dismissals = this.dismissalRepository.findAll();
        List<Dismissal> dismissalList = new ArrayList<>();
        dismissals.forEach(dismissal -> dismissalList.add(dismissal));
        return dismissalList;
    }

    public Optional<Dismissal> getDismissalById(DismissalId dismissalId){
        return this.dismissalRepository.findById(dismissalId);
    }

    public Dismissal addDismissal(Dismissal dismissal) {
        return this.dismissalRepository.save(dismissal);
    }

    public void deleteDismissal(Dismissal dismissal){
        this.dismissalRepository.delete(dismissal);
    }

    public List<BattingAnalysis> getBattingAnalyses(){
        Iterable<BattingAnalysis> battingAnalyses = this.battingAnalysisRepository.findAll();
        List<BattingAnalysis> battingAnalysisList = new ArrayList<>();
        battingAnalyses.forEach(battingAnalysis -> battingAnalysisList.add(battingAnalysis));
        return battingAnalysisList;
    }

    public Optional<BattingAnalysis> getBattingAnalysisByAnalysisId(AnalysisId analysisId){
        return this.battingAnalysisRepository.findById(analysisId);
    }

    public BattingAnalysis addBattingAnalysis(BattingAnalysis battingAnalysis){
        return this.battingAnalysisRepository.save(battingAnalysis);
    }

    public void deleteBattingAnalysis(BattingAnalysis battingAnalysis){
        this.battingAnalysisRepository.delete(battingAnalysis);
    }

    private List<BattingAnalysis> getAllBattingAnalysisByPlayerId(long playerId) {
        Iterable<BattingAnalysis> battingAnalyses = this.battingAnalysisRepository.findAllByAnalysisIdPlayerId(playerId);
        List<BattingAnalysis> battingAnalysisList = new ArrayList<>();
        battingAnalyses.forEach(battingAnalysis -> battingAnalysisList.add(battingAnalysis));
        return battingAnalysisList;
    }

    public List<BowlingAnalysis> getBowlingAnalyses(){
        Iterable<BowlingAnalysis> bowlingAnalyses = this.bowlingAnalysisRepository.findAll();
        List<BowlingAnalysis> bowlingAnalysisList = new ArrayList<>();
        bowlingAnalyses.forEach(bowlingAnalysis -> bowlingAnalysisList.add(bowlingAnalysis));
        return bowlingAnalysisList;
    }

    public Optional<BowlingAnalysis> getBowlingAnalysisByAnalysisId(AnalysisId analysisId){
        return this.bowlingAnalysisRepository.findById(analysisId);
    }

    public BowlingAnalysis addBowlingAnalysis(BowlingAnalysis bowlingAnalysis){
        return this.bowlingAnalysisRepository.save(bowlingAnalysis);
    }

    public void deleteBowlingAnalysis(BowlingAnalysis bowlingAnalysis){
        this.bowlingAnalysisRepository.delete(bowlingAnalysis);
    }

    public List<BowlingAnalysis> getAllBowlingAnalysisByPlayerId(long playerId){
        Iterable<BowlingAnalysis> bowlingAnalysisIterable = this.bowlingAnalysisRepository.findAllByAnalysisIdPlayerId(playerId);
        List<BowlingAnalysis> bowlingAnalysisList = new ArrayList<>();
        bowlingAnalysisIterable.forEach(bowlingAnalysis -> bowlingAnalysisList.add(bowlingAnalysis));
        return bowlingAnalysisList;
    }

    public List<FieldingAnalysis> getFieldingAnalyses(){
        Iterable<FieldingAnalysis> fieldingAnalyses = this.fieldingAnalysisRepository.findAll();
        List<FieldingAnalysis> fieldingAnalysisList = new ArrayList<>();
        fieldingAnalyses.forEach(fieldingAnalysis -> fieldingAnalysisList.add(fieldingAnalysis));
        return fieldingAnalysisList;
    }

    public Optional<FieldingAnalysis> getFieldingAnalysisByAnalysisId(AnalysisId analysisId){
        return this.fieldingAnalysisRepository.findById(analysisId);
    }

    public FieldingAnalysis addFieldingAnalysis(FieldingAnalysis fieldingAnalysis){
        return this.fieldingAnalysisRepository.save(fieldingAnalysis);
    }

    public void deleteFieldingAnalysis(FieldingAnalysis fieldingAnalysis){
        this.fieldingAnalysisRepository.delete(fieldingAnalysis);
    }

    private List<FieldingAnalysis> getAllFieldingAnalysisByPlayerId(long playerId) {
        List<FieldingAnalysis> fieldingAnalysisList = new ArrayList<>();
        Iterable<FieldingAnalysis> fieldingAnalyses = this.fieldingAnalysisRepository.findAllByAnalysisIdPlayerId(playerId);
        fieldingAnalyses.forEach(fieldingAnalysis -> fieldingAnalysisList.add(fieldingAnalysis));
        return fieldingAnalysisList;
    }

    public Optional<PlayerBowlingSummary> getPlayerBowlingSummary(long playerId) {
        Optional<PlayerBowlingSummary> playerBowlingSummaryOptional = this.playerBowlingSummaryRepository.findById(playerId);
        if(playerBowlingSummaryOptional.isPresent())
            return playerBowlingSummaryOptional;
        List<BowlingAnalysis> bowlingAnalysisList = getAllBowlingAnalysisByPlayerId(playerId);
        if(bowlingAnalysisList.isEmpty())
            return Optional.empty();
        PlayerBowlingSummary playerBowlingSummary = PlayerBowlingSummary.of(bowlingAnalysisList, playerId);
        playerBowlingSummaryRepository.save(playerBowlingSummary);
        return Optional.of(playerBowlingSummary);
    }

    public Optional<PlayerBattingSummary> getPlayerBattingSummary(long playerId) {
        Optional<PlayerBattingSummary> playerBattingSummaryOptional = this.playerBattingSummaryRepository.findById(playerId);
        if(playerBattingSummaryOptional.isPresent())
            return playerBattingSummaryOptional;
        List<BattingAnalysis> battingAnalysisList = this.getAllBattingAnalysisByPlayerId(playerId);
        if(battingAnalysisList.isEmpty())
            return Optional.empty();
        PlayerBattingSummary playerBattingSummary = PlayerBattingSummary.of(battingAnalysisList, playerId);
        this.playerBattingSummaryRepository.save(playerBattingSummary);
        return Optional.of(playerBattingSummary);
    }


    public Optional<PlayerFieldingSummary> getPlayerFieldingSummary(long playerId) {
        Optional<PlayerFieldingSummary> playerFieldingSummaryOptional = this.playerFieldingSummaryRepository.findById(playerId);
        if(playerFieldingSummaryOptional.isPresent())
            return playerFieldingSummaryOptional;
        List<FieldingAnalysis> fieldingAnalysisList = this.getAllFieldingAnalysisByPlayerId(playerId);
        if(fieldingAnalysisList.isEmpty())
            return Optional.empty();
        PlayerFieldingSummary playerFieldingSummary = PlayerFieldingSummary.of(fieldingAnalysisList, playerId);
        this.playerFieldingSummaryRepository.save(playerFieldingSummary);
        return Optional.of(playerFieldingSummary);
    }

}
