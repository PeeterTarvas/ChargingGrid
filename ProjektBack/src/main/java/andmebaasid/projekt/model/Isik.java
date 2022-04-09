package andmebaasid.projekt.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name= "isik")
public class Isik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isik_id;

    @Column()
    private String isikukood;

}
