package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER_FIELDING_SUMMARY")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class PlayerFieldingSummary {

    @Id
    @Column(name = "PlayerID")
    @JsonProperty("playerId")
    private long playerId;

    @Column(name = "Catches")
    @JsonProperty("catches")
    private int catches;

    @Column(name = "RunOuts")
    @JsonProperty("run_outs")
    private int runOuts;

    @Column(name = "Stumpings")
    @JsonProperty("stumpings")
    private int stumpings;

}
