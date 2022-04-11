package andmebaasid.projekt.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class LaadimisPunktiSeisundiLiik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int laadimispunkti_seisundi_liik_kood;

    @Column
    private String nimetus;
}
