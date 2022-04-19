package andmebaasid.projekt.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Isik {
    @Id
    private Long isik_id;

    @Column
    private String isikukood;

    @Column
    private Date synni_kp;


    @Column
    private Date reg_aeg;

    @Column
    private String eesnimi;

    @Column
    private String perenimi;

    @Column
    private String elukoht;

    @Column
    private String e_meil;

    @Column
    private String isikukoodi_riik;

    @Column
    private Long isiku_seisundi_liik_kood;
}
