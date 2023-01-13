package com.varunsrini.cricbase.cricketdatabase.entity.repository;

import com.varunsrini.cricbase.cricketdatabase.entity.data.BowlingAnalysis;
import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.AnalysisId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlingAnalysisRepository extends JpaRepository<BowlingAnalysis, AnalysisId> {

    Iterable<BowlingAnalysis> findAllByAnalysisIdPlayerId(long playerId);

    Iterable<BowlingAnalysis> findAllByAnalysisIdMatchId(long matchId);
}
