package Sound.Production.Sound.Production;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> {
    List<ReservationEntity> findByData(String data);
}
