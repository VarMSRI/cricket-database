package com.varunsrini.cricbase.cricketdatabase.entity.repository;

import com.varunsrini.cricbase.cricketdatabase.entity.data.Dismissal;
import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.DismissalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DismissalRepository extends JpaRepository<Dismissal, DismissalId> {

    Iterable<Dismissal> findAllByDismissalIdMatchId(long MatchId);

}
