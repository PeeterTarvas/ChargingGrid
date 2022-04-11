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

    @Id
    private Long tootaja_seisundi_liik_kood;

    @Column
    private Long laadimispunkti_tyyp_kood;

    @Column
    private Long tootaja_roll_kood;

    @Column
    private Long riik_kood;
}
