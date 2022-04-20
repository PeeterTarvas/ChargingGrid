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
public class LaadimispunktiKategooria {

    @Id
    @Column
    private Long laadimispunkti_kategooria_kood;

    @Column
    private String nimetus;

    @Column
    private Long laadimispunkti_kategooria_tyyp_kood;
}
