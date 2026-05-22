package Pensionaten.repositoires;

import Pensionaten.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsByCustomerId(Long customerId);
}