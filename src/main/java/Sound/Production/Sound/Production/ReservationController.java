package Sound.Production.Sound.Production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<ReservationEntity>> getAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservationEntity> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(reservationService.findById(id));
    }
    // READ BY DATA
    @GetMapping("/date")
    public ResponseEntity<List<ReservationEntity>> getByDate(@RequestParam String data) {
        return ResponseEntity.ok(reservationService.findByData(data));
    }
    // CREATE
    @PostMapping
    public ResponseEntity<ReservationEntity> create(
            @RequestBody ReservationEntity reservation) {
        return ResponseEntity.ok(reservationService.create(reservation));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ReservationEntity> update(
            @PathVariable Integer id,
            @RequestBody ReservationEntity reservation) {
        return ResponseEntity.ok(reservationService.update(id, reservation));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}