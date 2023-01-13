package com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.experimental.Accessors;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DismissalId implements Serializable {
    @Column(name = "MatchID")
    @JsonProperty("matchId")
    private long matchId;

    @Column(name = "BatterID")
    @JsonProperty("batterId")
    private long batterId;

    @Override
    public String toString() {
        return "DismissalId{" +
                "matchID=" + matchId +
                ", batterId=" + batterId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DismissalId that = (DismissalId) o;
        return matchId == that.matchId && batterId == that.batterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, batterId);
    }
}
