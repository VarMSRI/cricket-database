package com.varunsrini.cricbase.cricketdatabase.entity.repository;

import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.AnalysisId;
import com.varunsrini.cricbase.cricketdatabase.entity.data.BattingAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BattingAnalysisRepository extends JpaRepository<BattingAnalysis, AnalysisId> {

    Iterable<BattingAnalysis> findAllByAnalysisIdPlayerId(long playerId);

    Iterable<BattingAnalysis> findAllByAnalysisIdMatchId(long matchId);

}
