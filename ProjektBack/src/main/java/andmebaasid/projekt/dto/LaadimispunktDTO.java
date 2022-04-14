package andmebaasid.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class LaadimispunktDTO {
    private Long laadimispunkti_kood;
    private Double laiuskraad;
    private String nimetus;
    private Double pikkuskraad;
    private Date reg_aeg;
    private Long registreerija_id;
    private Long laadimispunkti_seisundi_liik_kood;
    private Long laadimispunkti_tyyp_id;
    private String laadimispunkti_seisundi_nimetus;
}
