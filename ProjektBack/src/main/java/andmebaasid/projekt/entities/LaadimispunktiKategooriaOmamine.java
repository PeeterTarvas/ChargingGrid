package andmebaasid.projekt.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@Entity
@NoArgsConstructor
@IdClass(PrimaryKey.class)
public class LaadimispunktiKategooriaOmamine {

    @Id
    @Column
    private Long laadimispunkti_kood;

    @Id
    @Column
    private Long laadimispunkti_kategooria_kood;
}
