package sk.fri.uniza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class IotNode {

    @Id
    @NaturalId //Primárny klúč nie je generovaný, ale je tvorený názvom premennej
    @NotEmpty
    private Long id;

    @NotEmpty
    private String Name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "houseHold")
    @JsonIgnore // Ignorovanie danej premenej z pohladu Serializacie do
    // objektu JSON. Generoval by sa obrovský JSON a dochádzalo by aj k
    // zacykleniu
    private HouseHold houseHold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public HouseHold getHouseHold() {
        return houseHold;
    }

    public void setHouseHold(HouseHold houseHold) {
        this.houseHold = houseHold;
    }
}
