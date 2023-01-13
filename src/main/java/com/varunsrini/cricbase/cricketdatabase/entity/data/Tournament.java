package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Entity
@Table(name = "TOURNAMENT")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TournamentID")
    @JsonProperty("tournamentId")
    private long tournamentId;

    @Column(name = "TournamentName")
    @JsonProperty("tournamentName")
    private String tournamentName;

    @Column(name = "StartYear")
    @JsonProperty("startYear")
    private String startYear;

    @Column(name = "Grade")
    @JsonProperty("grade")
    private String grade;

    @Column(name = "EndYear")
    @JsonProperty("endYear")
    private String endYear;

    @Override
    public String toString() {
        return "Tournament{" +
                "tournamentId=" + tournamentId +
                ", tournamentName='" + tournamentName + '\'' +
                ", startYear='" + startYear + '\'' +
                ", grade='" + grade + '\'' +
                ", endYear='" + endYear + '\'' +
                '}';
    }
}
