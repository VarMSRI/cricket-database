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
@Table(name = "PLAYER_BOWLING_SUMMARY")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class PlayerBowlingSummary {

    @Id
    @Column(name = "PlayerID")
    @JsonProperty("playerId")
    private long playerId;

    @Column(name = "Overs")
    @JsonProperty("overs")
    private float overs;

    @Column(name = "RunsConceded")
    @JsonProperty("runs_conceded")
    private int runsConceded;

    @Column(name = "Wickets")
    @JsonProperty("wickets")
    private int wickets;

    @Column(name = "Maidens")
    @JsonProperty("maidens")
    private int maidens;

    @Column(name = "BowlingAverage")
    @JsonProperty("bowling_average")
    private float bowlingAverage;

    @Column(name = "BowlingStrikeRate")
    @JsonProperty("bowling_strike_rate")
    private float bowlingStrikeRate;

    public static PlayerBowlingSummary of(List<BowlingAnalysis> bowlingAnalysisList, long playerId){
        float overs = bowlingAnalysisList.stream().map(bowlingAnalysis -> bowlingAnalysis.oversBowled()).reduce(0.0F, Float::sum).floatValue();
        int maidens = bowlingAnalysisList.stream().map(bowlingAnalysis -> bowlingAnalysis.maidens()).reduce(0, Integer::sum).intValue();
        int runs = bowlingAnalysisList.stream().map(bowlingAnalysis -> bowlingAnalysis.runsConceded()).reduce(0, Integer::sum).intValue();
        int wickets = bowlingAnalysisList.stream().map(bowlingAnalysis -> bowlingAnalysis.wickets()).reduce(0, Integer::sum).intValue();

        float average = wickets != 0? ((float) runs/(float) wickets): 0.0F;
        float strikeRate = wickets != 0? overs*6/wickets: 0.0F;

        return new PlayerBowlingSummary(playerId, overs, runs, wickets, maidens, average, strikeRate);
    }
}
