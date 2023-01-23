package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.AnalysisId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BOWLING_ANALYSIS")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BowlingAnalysis {

    @EmbeddedId
    private AnalysisId analysisId;

    @Column(name = "OversBowled")
    @JsonProperty("oversBowled")
    private float oversBowled;

    @Column(name = "RunsConceded")
    @JsonProperty("runsConceded")
    private int runsConceded;

    @Column(name = "Maidens")
    @JsonProperty("maidens")
    private int maidens;

    @Column(name = "Wickets")
    @JsonProperty("wickets")
    private int wickets;

    @Override
    public String toString() {
        return "BowlingAnalysis{" +
                "analysisId=" + analysisId +
                ", oversBowled=" + oversBowled +
                ", runsConceded=" + runsConceded +
                ", maidens=" + maidens +
                ", wickets=" + wickets +
                '}';
    }
}
