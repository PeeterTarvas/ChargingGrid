package andmebaasid.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class LaadimispunktDTO {
    private Long laadimispunkti_kood;
    private String nimetus;
    private Double laiuskraad;
    private Double pikkuskraad;
    private Date reg_aeg;
    private Long registreerija_id;
    private Long laadimispunkti_seisundi_liik_kood;
    private Long laadimispunkti_tyyp_id;
    private String laadimispunkti_seisundi_nimetus;
    private String eesnimi;
    private String perenimi;
    private String e_post;
    private Integer laadimispunkti_tyyp_nimi;
}
