package com.varunsrini.cricbase.cricketdatabase.entity.repository;

import com.varunsrini.cricbase.cricketdatabase.entity.data.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Iterable<Player> findPlayerByFirstName(String firstName);

    Iterable<Player> findPlayerByLastName(String lastName);
}
