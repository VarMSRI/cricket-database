package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PLAYER_BATTING_SUMMARY")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class PlayerBattingSummary {

    @Id
    @Column(name = "PlayerID")
    @JsonProperty("playerId")
    private long playerId;

    @Column(name = "Matches")
    @JsonProperty("matches")
    private int matches;

    @Column(name = "Innings")
    @JsonProperty("innings")
    private int innings;

    @Column(name = "NotOuts")
    @JsonProperty("not_outs")
    private int notOuts;

    @Column(name = "Runs")
    @JsonProperty("runs")
    private int runs;

    @Column(name = "Balls")
    @JsonProperty("balls")
    private int balls;

    @Column(name = "Average")
    @JsonProperty("average")
    private float average;

    @Column(name = "StrikeRate")
    @JsonProperty("strike_rate")
    private float strikeRate;

    public static PlayerBattingSummary of(List<BattingAnalysis> battingAnalysisList, long playerId) {
        int matches = battingAnalysisList.size();
        int innings = (int) battingAnalysisList.stream().filter(battingAnalysis -> !battingAnalysis.dismissalStatus().equalsIgnoreCase("dnb")).count();
        int notOuts = (int) battingAnalysisList.stream().filter(battingAnalysis -> battingAnalysis.dismissalStatus().equalsIgnoreCase("notout")).count();
        int runs = battingAnalysisList.stream().map(battingAnalysis -> battingAnalysis.runsScored()).reduce(0,Integer::sum).intValue();
        int balls = battingAnalysisList.stream().map(battingAnalysis -> battingAnalysis.ballsFaced()).reduce(0,Integer::sum).intValue();
        float average = (innings - notOuts) == 0? null : (float) runs/(innings - notOuts);
        float strikeRate = (float) runs/(float) balls;
        return new PlayerBattingSummary(playerId, matches, innings, notOuts, runs, balls, average, strikeRate*100);
    }
}
