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
public class Tootaja {
    @Id
    @Column
    private Long isik_id;

    @Column
    private Long mentor;

    @Column
    private Long klassifikaatori_kood;
}
