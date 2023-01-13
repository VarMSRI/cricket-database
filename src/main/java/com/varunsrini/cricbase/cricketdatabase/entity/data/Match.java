package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MATCHES")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MatchID")
    @JsonProperty("matchId")
    private long matchId;

    @Column(name = "TournamentID")
    @JsonProperty("tournamentId")
    private long tournamentID;

    @Column(name = "TeamID1")
    @JsonProperty("teamIdOne")
    private long teamId1;

    @Column(name = "TeamID2")
    @JsonProperty("teamIdTwo")
    private long teamId2;

    @Column(name = "Venue")
    @JsonProperty("venue")
    private String venue;

    @Column(name = "DatePlayed")
    @JsonProperty("datePlayed")
    private Date datePlayed;

    @Override
    public String toString() {
        return "Matches{" +
                "matchId=" + matchId +
                ", tournamentID=" + tournamentID +
                ", teamId1=" + teamId1 +
                ", teamId2=" + teamId2 +
                ", venue='" + venue + '\'' +
                ", datePlayed=" + datePlayed +
                '}';
    }
}
