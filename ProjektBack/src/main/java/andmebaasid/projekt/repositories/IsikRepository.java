package andmebaasid.projekt.repositories;

import andmebaasid.projekt.entities.Isik;
import andmebaasid.projekt.entities.Laadimispunkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IsikRepository extends JpaRepository<Isik, Integer> {

    @Query("SELECT i FROM Isik i WHERE i.isik_id = :id")
    Isik findByIsikId(Long id);
}
