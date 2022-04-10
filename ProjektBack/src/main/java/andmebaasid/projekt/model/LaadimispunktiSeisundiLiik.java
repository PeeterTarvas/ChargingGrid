package andmebaasid.projekt.model;

import javax.persistence.*;

@Entity
@Table(name= "laadimispunkti_seisundi_liik")
public class LaadimispunktiSeisundiLiik {

    @Id
    @Column(name = "laadimispunkti_seisundi_liik_kood")
    private Long laadimispunkti_seisundi_liik_kood;

    @Column(name = "nimetus")
    private String nimetus;

}
