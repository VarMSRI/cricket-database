package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MatchSummary {

    @JsonProperty("matchId")
    private long matchId;

    @JsonProperty("batting_card")
    private Map<Long, List<BattingAnalysis>> battingCardSummary;

    @JsonProperty("bowling_card")
    private Map<Long, List<BowlingAnalysis>> bowlingCardSummary;

    public static MatchSummary of(long matchId, Iterable<BattingAnalysis> battingAnalyses, Iterable<BowlingAnalysis> bowlingAnalyses){
        List<BattingAnalysis> battingAnalysisList = StreamSupport.stream(battingAnalyses.spliterator(), false).collect(Collectors.toList());
        List<BowlingAnalysis> bowlingAnalysisList = StreamSupport.stream(bowlingAnalyses.spliterator(), false).collect(Collectors.toList());

        Map<Long, List<BattingAnalysis>> battingAnalysisMap = battingAnalysisList.stream()
                .collect(Collectors.groupingBy(battingAnalysis -> battingAnalysis.analysisId().teamId()));

        Map<Long, List<BowlingAnalysis>> bowlingAnalysisMap = bowlingAnalysisList.stream()
                        .collect(Collectors.groupingBy(bowlingAnalysis -> bowlingAnalysis.analysisId().teamId()));

        battingAnalysisMap.replaceAll((k, v) -> v.stream().sorted((a, b) -> {
            if (a.runsScored() != b.runsScored())
                return Integer.compare(b.runsScored(), a.runsScored());
            return Integer.compare(a.ballsFaced(), b.ballsFaced());
        }).limit(3).collect(Collectors.toList()));

        bowlingAnalysisMap.replaceAll((k, v) -> v.stream().sorted((a, b) -> {
            if(a.wickets() != b.wickets())
                return Integer.compare(b.wickets(), a.wickets());
            return Integer.compare(a.runsConceded(), b.runsConceded());
        }).limit(3).collect(Collectors.toList()));

        return new MatchSummary(matchId, battingAnalysisMap, bowlingAnalysisMap);
    }
}
