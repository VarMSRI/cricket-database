package com.varunsrini.cricbase.cricketdatabase.entity.repository;

import com.varunsrini.cricbase.cricketdatabase.entity.data.FieldingAnalysis;
import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.AnalysisId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldingAnalysisRepository extends JpaRepository<FieldingAnalysis, AnalysisId> {
}
