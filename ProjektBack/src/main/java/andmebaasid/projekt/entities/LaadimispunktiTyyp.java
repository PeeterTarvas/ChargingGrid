package andmebaasid.projekt.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class LaadimispunktiTyyp {

    @Column
    private Long kwh;

    @Id
    @Column
    private Long laadimispunkti_tyyp_kood;
}
