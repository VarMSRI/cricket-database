package com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class AnalysisId implements Serializable {

    @Column(name = "PlayerID")
    @JsonProperty("playerId")
    private long playerId;

    @Column(name = "MatchID")
    @JsonProperty("matchId")
    private long matchId;

    @Column(name = "TeamID")
    @JsonProperty("teamId")
    private long teamId;

    @Override
    public String toString() {
        return "AnalysisId{" +
                "playerId=" + playerId +
                ", matchId=" + matchId +
                ", teamId=" + teamId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalysisId that = (AnalysisId) o;
        return playerId == that.playerId && matchId == that.matchId && teamId == that.teamId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, matchId, teamId);
    }
}
