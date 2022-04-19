package andmebaasid.projekt.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Koondaruanne {
    private Long seisundi_kood;
    private String nimetus;
    private Long laadimispunktide_arv;
}
