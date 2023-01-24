package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEAM")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TeamID")
    @JsonProperty("teamId")
    private long teamId;

    @Column(name = "Name")
    @JsonProperty("name")
    private String name;

    @Column(name = "Division")
    @JsonProperty("division")
    private String division;

    @Column(name = "Grade")
    @JsonProperty("grade")
    private String grade;

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", name='" + name + '\'' +
                ", division='" + division + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
