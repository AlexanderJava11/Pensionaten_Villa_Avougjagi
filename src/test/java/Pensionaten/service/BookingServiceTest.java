package Pensionaten.service;

import Pensionaten.dto.BookingDTO;
import Pensionaten.models.Booking;
import Pensionaten.models.Customer;
import Pensionaten.models.Room;
import Pensionaten.models.RoomType;
import Pensionaten.repositories.BookingRepository;
import Pensionaten.repositories.CustomerRepository;
import Pensionaten.repositories.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private RoomService roomService;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void findAll_shouldReturnBookingDTOList() {
        Customer customer = Customer.builder()
                .id(1L)
                .firstName("Alex")
                .lastName("Zeljic")
                .email("alex@test.se")
                .phone("0701234567")
                .build();

        Room room = Room.builder()
                .id(1L)
                .roomNumber("101")
                .roomType(RoomType.SINGLE)
                .extraBeds(0)
                .build();

        Booking booking = new Booking();
        booking.setId(1L);
        booking.setCustomer(customer);
        booking.setRoom(room);
        booking.setCheckInDate(LocalDate.of(2026, 6, 1));
        booking.setCheckOutDate(LocalDate.of(2026, 6, 3));
        booking.setNumberOfGuests(1);

        when(bookingRepository.findAll()).thenReturn(List.of(booking));

        List<BookingDTO> result = bookingService.findAll();

        assertEquals(1, result.size());
        assertEquals("Alex", result.get(0).getCustomerFirstName());
        assertEquals("101", result.get(0).getRoomNumber());
    }

    @Test
    void findById_shouldReturnBookingDTO_whenBookingExists() {
        Customer customer = Customer.builder()
                .id(1L)
                .firstName("Alex")
                .lastName("Zeljic")
                .email("alex@test.se")
                .phone("0701234567")
                .build();

        Room room = Room.builder()
                .id(1L)
                .roomNumber("101")
                .roomType(RoomType.SINGLE)
                .extraBeds(0)
                .build();

        Booking booking = new Booking();
        booking.setId(1L);
        booking.setCustomer(customer);
        booking.setRoom(room);
        booking.setCheckInDate(LocalDate.of(2026, 6, 1));
        booking.setCheckOutDate(LocalDate.of(2026, 6, 3));
        booking.setNumberOfGuests(1);

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        BookingDTO result = bookingService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Alex", result.getCustomerFirstName());
    }

    @Test
    void findById_shouldReturnNull_whenBookingDoesNotExist() {
        when(bookingRepository.findById(99L)).thenReturn(Optional.empty());

        BookingDTO result = bookingService.findById(99L);

        assertNull(result);
    }

    @Test
    void saveBooking_shouldReturnFalse_whenDatesAreMissing() {
        BookingDTO dto = new BookingDTO();

        boolean result = bookingService.saveBooking(dto);

        assertFalse(result);
        verify(bookingRepository, never()).save(any());
    }

    @Test
    void saveBooking_shouldReturnFalse_whenCheckoutIsBeforeCheckin() {
        BookingDTO dto = new BookingDTO();
        dto.setCheckInDate(LocalDate.of(2026, 6, 3));
        dto.setCheckOutDate(LocalDate.of(2026, 6, 1));

        boolean result = bookingService.saveBooking(dto);

        assertFalse(result);
        verify(bookingRepository, never()).save(any());
    }

    @Test
    void saveBooking_shouldReturnFalse_whenRoomIsNotAvailable() {
        BookingDTO dto = new BookingDTO();
        dto.setCustomerId(1L);
        dto.setRoomId(1L);
        dto.setCheckInDate(LocalDate.of(2026, 6, 1));
        dto.setCheckOutDate(LocalDate.of(2026, 6, 3));
        dto.setNumberOfGuests(1);

        when(roomService.isRoomAvailable(1L, dto.getCheckInDate(), dto.getCheckOutDate(), 1, null))
                .thenReturn(false);

        boolean result = bookingService.saveBooking(dto);

        assertFalse(result);
        verify(bookingRepository, never()).save(any());
    }

    @Test
    void saveBooking_shouldReturnTrue_whenBookingIsValid() {
        BookingDTO dto = new BookingDTO();
        dto.setCustomerId(1L);
        dto.setRoomId(1L);
        dto.setCheckInDate(LocalDate.of(2026, 6, 1));
        dto.setCheckOutDate(LocalDate.of(2026, 6, 3));
        dto.setNumberOfGuests(1);

        Customer customer = Customer.builder()
                .id(1L)
                .firstName("Alex")
                .lastName("Zeljic")
                .email("alex@test.se")
                .phone("0701234567")
                .build();

        Room room = Room.builder()
                .id(1L)
                .roomNumber("101")
                .roomType(RoomType.SINGLE)
                .extraBeds(0)
                .build();

        when(roomService.isRoomAvailable(1L, dto.getCheckInDate(), dto.getCheckOutDate(), 1, null))
                .thenReturn(true);
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(roomRepository.findById(1L)).thenReturn(Optional.of(room));

        boolean result = bookingService.saveBooking(dto);

        assertTrue(result);
        verify(bookingRepository, times(1)).save(any(Booking.class));
    }

    @Test
    void deleteById_shouldReturnFalse_whenBookingDoesNotExist() {
        when(bookingRepository.existsById(99L)).thenReturn(false);

        boolean result = bookingService.deleteById(99L);

        assertFalse(result);
        verify(bookingRepository, never()).deleteById(99L);
    }

    @Test
    void deleteById_shouldReturnTrue_whenBookingExists() {
        when(bookingRepository.existsById(1L)).thenReturn(true);

        boolean result = bookingService.deleteById(1L);

        assertTrue(result);
        verify(bookingRepository, times(1)).deleteById(1L);
    }
}