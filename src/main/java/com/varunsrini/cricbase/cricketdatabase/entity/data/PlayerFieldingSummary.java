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

    public static PlayerFieldingSummary of(List<FieldingAnalysis> fieldingAnalysisList, long playerId) {
        int catches = fieldingAnalysisList.stream().map(fieldingAnalysis -> fieldingAnalysis.catches()).reduce(0,Integer::sum).intValue();
        int runOuts = fieldingAnalysisList.stream().map(fieldingAnalysis -> fieldingAnalysis.runOuts()).reduce(0, Integer::sum).intValue();
        int stumpings = fieldingAnalysisList.stream().map(fieldingAnalysis -> fieldingAnalysis.stumpings()).reduce(0, Integer::sum).intValue();

        return new PlayerFieldingSummary(playerId, catches, runOuts, stumpings);
    }
}
