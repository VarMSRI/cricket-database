package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PLAYER")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlayerID")
    @JsonProperty("playerId")
    private long playerId;

    @Column(name = "FName")
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "LName")
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "DOB")
    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "PrimarySkill")
    @JsonProperty("primarySkill")
    private String primarySkill;

    @Column(name = "SecondarySkill")
    @JsonProperty("secondarySkill")
    private String secondarySkill;

    @Column(name = "BowlingArm")
    @JsonProperty("bowlingArm")
    private String bowlingArm;

    @Column(name = "BattingHand")
    @JsonProperty("battingHand")
    private String battingHand;

    @Column(name = "TeamID")
    @JsonProperty("teamId")
    private long teamId;

    @Column(name = "DebutID")
    @JsonProperty("debutMatchId")
    private long debutMatchId;

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", primarySkill='" + primarySkill + '\'' +
                ", secondarySkill='" + secondarySkill + '\'' +
                ", bowlingArm='" + bowlingArm + '\'' +
                ", battingHand='" + battingHand + '\'' +
                ", teamId=" + teamId +
                ", debutMatchId=" + debutMatchId +
                '}';
    }
}
