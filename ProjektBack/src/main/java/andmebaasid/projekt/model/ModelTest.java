package andmebaasid.projekt.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laadimispunkti_seisundi_liik")
public class ModelTest {

    @Id
    @Column(name = "laadimispunkti_seisundi_liik_kood")
    private int kood;

    @Column(name = "nimetus")
    private String nimetus;

}
