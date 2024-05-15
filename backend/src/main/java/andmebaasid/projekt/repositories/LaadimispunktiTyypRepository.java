package andmebaasid.projekt.repositories;

import andmebaasid.projekt.entities.LaadimispunktiSeisundiLiik;
import andmebaasid.projekt.entities.LaadimispunktiTyyp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LaadimispunktiTyypRepository extends JpaRepository<LaadimispunktiTyyp, Integer> {
    @Query("SELECT l FROM LaadimispunktiTyyp l WHERE l.laadimispunkti_tyyp_kood = :kood")
    LaadimispunktiTyyp findByLaadimispunkti_tyyp_kood(Long kood);
}
