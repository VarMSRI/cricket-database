package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.AnalysisId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "BATTING_ANALYSIS")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BattingAnalysis {
     @EmbeddedId
     private AnalysisId analysisId;

     @Column(name = "BallsFaced")
     @JsonProperty("ballsFaced")
     private int ballsFaced;

     @Column(name = "RunsScored")
     @JsonProperty("runsScored")
     private int runsScored;

     @Column(name = "DismissalStatus")
     @JsonProperty("dismissalStatus")
     private String dismissalStatus;

     @Column(name = "Fours")
     @JsonProperty("fours")
     private int fours;

     @Column(name = "Sixes")
     @JsonProperty("sixes")
     private int sixes;

    @Override
    public String toString() {
        return "BattingAnalysis{" +
                "analysisId=" + analysisId +
                ", ballsFaced=" + ballsFaced +
                ", runsScored=" + runsScored +
                ", dismissalStatus='" + dismissalStatus + '\'' +
                ", fours=" + fours +
                ", sixes=" + sixes +
                '}';
    }
}
