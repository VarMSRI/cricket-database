package com.varunsrini.cricbase.cricketdatabase.entity.repository;

import com.varunsrini.cricbase.cricketdatabase.entity.data.PlayerFieldingSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerFieldingSummaryRepository extends JpaRepository<PlayerFieldingSummary, Long> {
}