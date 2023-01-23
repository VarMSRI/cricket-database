package com.varunsrini.cricbase.cricketdatabase.entity.repository;

import com.varunsrini.cricbase.cricketdatabase.entity.data.PlayerBattingSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerBattingSummaryRepository extends JpaRepository<PlayerBattingSummary, Long> {
}