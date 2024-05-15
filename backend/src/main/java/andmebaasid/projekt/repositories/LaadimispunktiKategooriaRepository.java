package andmebaasid.projekt.repositories;

import andmebaasid.projekt.entities.LaadimispunktiKategooria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LaadimispunktiKategooriaRepository extends JpaRepository<LaadimispunktiKategooria, Integer> {

    @Query("SELECT l FROM LaadimispunktiKategooria l WHERE l.laadimispunkti_kategooria_kood=:kood")
    LaadimispunktiKategooria findKategooriaByKood(Integer kood);
}
