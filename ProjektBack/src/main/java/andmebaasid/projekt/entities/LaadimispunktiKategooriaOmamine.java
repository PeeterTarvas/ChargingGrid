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
public class LaadimispunktiKategooriaOmamine {

    @Id
    private Long laadimispunkti_kood;

    @Column
    private Long klassifikaatori_kood;
}
