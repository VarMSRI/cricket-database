package com.varunsrini.cricbase.cricketdatabase.entity.repository;

import com.varunsrini.cricbase.cricketdatabase.entity.data.PlayerBowlingSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerBowlingSummaryRepository extends JpaRepository<PlayerBowlingSummary, Long> {
}