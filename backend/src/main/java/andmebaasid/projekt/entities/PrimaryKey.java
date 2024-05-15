package andmebaasid.projekt.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PrimaryKey implements Serializable {
    private Long laadimispunkti_kood;
    private Integer laadimispunkti_kategooria_kood;
}
