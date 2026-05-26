package Pensionaten.service;

import Pensionaten.dto.CustomerDTO;
import Pensionaten.models.Customer;
import Pensionaten.repositories.BookingRepository;
import Pensionaten.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void findAll_shouldReturnCustomerDTOList() {
        Customer customer = Customer.builder()
                .id(1L)
                .firstName("Alex")
                .lastName("Zeljic")
                .email("alex@test.se")
                .phone("0701234567")
                .build();

        when(customerRepository.findAll()).thenReturn(List.of(customer));

        List<CustomerDTO> result = customerService.findAll();

        assertEquals(1, result.size());
        assertEquals("Alex", result.get(0).getFirstName());
        assertEquals("Zeljic", result.get(0).getLastName());
    }

    @Test
    void findById_shouldReturnCustomerDTO_whenCustomerExists() {
        Customer customer = Customer.builder()
                .id(1L)
                .firstName("Alex")
                .lastName("Zeljic")
                .email("alex@test.se")
                .phone("0701234567")
                .build();

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        CustomerDTO result = customerService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Alex", result.getFirstName());
    }

    @Test
    void findById_shouldReturnNull_whenCustomerDoesNotExist() {
        when(customerRepository.findById(99L)).thenReturn(Optional.empty());

        CustomerDTO result = customerService.findById(99L);

        assertNull(result);
    }

    @Test
    void save_shouldSaveCustomer() {
        CustomerDTO dto = CustomerDTO.builder()
                .id(1L)
                .firstName("Alex")
                .lastName("Zeljic")
                .email("alex@test.se")
                .phone("0701234567")
                .build();

        customerService.save(dto);

        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void delete_shouldReturnFalse_whenCustomerHasBookings() {
        when(bookingRepository.existsByCustomerId(1L)).thenReturn(true);

        boolean result = customerService.delete(1L);

        assertFalse(result);
        verify(customerRepository, never()).deleteById(1L);
    }

    @Test
    void delete_shouldReturnTrue_whenCustomerHasNoBookings() {
        when(bookingRepository.existsByCustomerId(1L)).thenReturn(false);

        boolean result = customerService.delete(1L);

        assertTrue(result);
        verify(customerRepository, times(1)).deleteById(1L);
    }
}