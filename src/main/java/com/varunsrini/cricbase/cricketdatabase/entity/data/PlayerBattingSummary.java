package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER_BATTING_SUMMARY")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PlayerBattingSummary {

    @Id
    @Column(name = "PlayerID")
    @JsonProperty("playerId")
    private long playerId;

    @Column(name = "Matches")
    @JsonProperty("matches")
    private int matches;

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
}
