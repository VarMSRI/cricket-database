package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name = "FIELDING_ANALYSIS")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class FieldingAnalysis {

    @EmbeddedId
    @JsonInclude
    @JsonProperty("id")
    private AnalysisId analysisId;

    @Column(name = "Catches")
    @JsonProperty("catches")
    private int catches;

    @Column(name = "Stumpings")
    @JsonProperty("stumpings")
    private int stumpings;

    @Column(name = "RunOuts")
    @JsonProperty("runOuts")
    private int runOuts;

    @Override
    public String toString() {
        return "FieldingAnalysis{" +
                "analysisId=" + analysisId +
                ", catches=" + catches +
                ", stumpings=" + stumpings +
                ", runOuts=" + runOuts +
                '}';
    }
}
