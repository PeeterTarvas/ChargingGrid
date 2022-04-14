package andmebaasid.projekt.repositories;

import andmebaasid.projekt.entities.Tootaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TootajaRepository extends JpaRepository<Tootaja, Integer> {
}
