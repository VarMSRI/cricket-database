package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    
}
