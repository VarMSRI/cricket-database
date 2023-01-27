package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.AbstractStandardBasicType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER_SUMMARY")
@Accessors(fluent = true)
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class PlayerSummary {

    @Id
    @Column(name = "PlayerID")
    @JsonProperty("playerId")
    private long playerId;

    @Type(type = "json")
    @Column(name = "player", columnDefinition = "json")
    @JsonProperty("Player")
    private Player player;

    @Type(type = "json")
    @Column(name = "batting_summary", columnDefinition = "json")
    @JsonProperty("batting_summary")
    private PlayerBattingSummary playerBattingSummary;

    @Type(type = "json")
    @Column(name = "bowling_summary", columnDefinition = "json")
    @JsonProperty("bowling_summary")
    private PlayerBowlingSummary playerBowlingSummary;

    @Type(type = "json")
    @Column(name = "fielding_summary", columnDefinition = "json")
    @JsonProperty("fielding_summary")
    private PlayerFieldingSummary playerFieldingSummary;

}
