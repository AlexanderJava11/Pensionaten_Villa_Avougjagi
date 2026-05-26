package Pensionaten.repositories;

import Pensionaten.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository för bokningar. Spring Data JPA skapar grundläggande databasmetoder automatiskt
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Används för att kontrollera om en kund har bokningar innan kunden tas bort
    boolean existsByCustomerId(Long customerId);

    // Används för att kontrollera om ett rum har bokningar innan rummet tas bort
    boolean existsByRoomId(Long roomId);
}