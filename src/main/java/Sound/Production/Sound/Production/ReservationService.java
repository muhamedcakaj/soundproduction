package Sound.Production.Sound.Production;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    // READ ALL
    public List<ReservationEntity> findAll() {
        return reservationRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    // READ BY ID
    public ReservationEntity findById(Integer id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }
    //READ BY DATE
    public List<ReservationEntity>findByData(String data) {
        return reservationRepository.findByData(data);
    }

    // CREATE
    public ReservationEntity create(ReservationEntity reservation) {
        return reservationRepository.save(reservation);
    }

    // UPDATE
    public ReservationEntity update(Integer id, ReservationEntity updated) {
        ReservationEntity existing = findById(id);

        existing.setName(updated.getName());
        existing.setSurname(updated.getSurname());
        existing.setContact(updated.getContact());
        existing.setPrice(updated.getPrice());
        existing.setData(updated.getData());
        existing.setTimeAM(updated.getTimeAM());
        existing.setTimepm(updated.getTimepm());
        existing.setPhotoshooting(updated.getPhotoshooting());
        existing.setStatus(updated.getStatus());
        existing.setDetails(updated.getDetails());

        return reservationRepository.save(existing);
    }

    // DELETE
    public void delete(Integer id) {
        reservationRepository.deleteById(id);
    }
}
