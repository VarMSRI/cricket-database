package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PlayerSummary {

    @JsonProperty("playerId")
    private long playerId;

    @JsonProperty("Player")
    private Player player;

    @JsonProperty("batting_summary")
    private PlayerBattingSummary playerBattingSummary;

    @JsonProperty("bowling_summary")
    private PlayerBowlingSummary playerBowlingSummary;

    @JsonProperty("fielding_summary")
    private PlayerFieldingSummary playerFieldingSummary;

}
