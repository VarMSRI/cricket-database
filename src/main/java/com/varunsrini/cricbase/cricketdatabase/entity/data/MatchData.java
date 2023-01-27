package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Accessors(fluent = true)
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MatchData {

    @JsonProperty("matchId")
    private long matchId;

    @JsonProperty("batting_analyses")
    private List<BattingAnalysis> battingAnalysisList;

    @JsonProperty("bowling_analyses")
    private List<BowlingAnalysis> bowlingAnalysisList;

    @JsonProperty("dismissals")
    private List<Dismissal> dismissalList;

    public static MatchData of(long matchId, Iterable<BattingAnalysis> battingAnalysisIterable, Iterable<BowlingAnalysis> bowlingAnalysisIterable, Iterable<Dismissal> dismissalIterable) {
        List<BattingAnalysis> battingAnalyses = StreamSupport.stream(battingAnalysisIterable.spliterator(), false).collect(Collectors.toList());
        List<BowlingAnalysis> bowlingAnalyses = StreamSupport.stream(bowlingAnalysisIterable.spliterator(), false).collect(Collectors.toList());
        List<Dismissal> dismissals = StreamSupport.stream(dismissalIterable.spliterator(), false).collect(Collectors.toList());

        return new MatchData(matchId, battingAnalyses, bowlingAnalyses, dismissals);
    }

}
