package com.varunsrini.cricbase.cricketdatabase.entity.repository;

import com.varunsrini.cricbase.cricketdatabase.entity.data.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Iterable<Player> findPlayerByFirstName(String firstName);
    Iterable<Player> findPlayerByLastName(String lastName);

    @Query(value = "SELECT playerId FROM Player p WHERE p.teamId = :teamId and p.playerId != :excludeId", nativeQuery = true)
    List<Long> findPlayerIdsByTeamId(@Param("teamId") long teamId, @Param("excludeId") long excludeId);
}
