package andmebaasid.projekt.repositories;

import andmebaasid.projekt.entities.LaadimispunktiKategooriaTyyp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LaadimispunktiKategooriaTyypRepository extends JpaRepository<LaadimispunktiKategooriaTyyp, Integer> {

    @Query("SELECT l.laadimispunkti_kategooria_tyyp_nimetus FROM LaadimispunktiKategooriaTyyp l WHERE l.laadimispunkti_kategooria_tyyp_kood=:kood")
    String findKategooriaTyypNimetusByKood(Integer kood);
}
