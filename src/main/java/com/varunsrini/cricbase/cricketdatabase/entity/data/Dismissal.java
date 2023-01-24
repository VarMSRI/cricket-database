package com.varunsrini.cricbase.cricketdatabase.entity.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.varunsrini.cricbase.cricketdatabase.entity.data.embeddedkeys.DismissalId;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DISMISSAL")
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Dismissal implements Serializable {

    @EmbeddedId
    @JsonInclude
    @JsonProperty("id")
    private DismissalId dismissalId;

    @Column(name = "BowlerID")
    @JsonProperty("bowlerId")
    private long bowlerID;

    @Column(name = "FielderID")
    @JsonProperty("fielderId")
    private long fielderId;

    @Column(name = "NatureOfDismissal")
    @JsonProperty("natureOfDismissal")
    private String natureOfDismissal;

    @Override
    public String toString() {
        return "Dismissal{" +
                "dismissalId=" + dismissalId +
                ", bowlerID=" + bowlerID +
                ", fielderId=" + fielderId +
                ", natureOfDismissal='" + natureOfDismissal + '\'' +
                '}';
    }
}
