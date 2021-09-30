package practice2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApartmentServiceTest {
    @Mock
    private ApartmentRepository repository;
    @Captor
    private ArgumentCaptor<Apartment> captorApartment;

    private ApartmentService service;

    @BeforeEach
    void setUp() {
        service = new ApartmentService(repository);
    }

    @Test
    void should_update_apartment_success() throws ResourceNotFoundException, Exception {
        int apartmentId = 123;
        ApartmentRequest request = new ApartmentRequest(apartmentId, "new address", "new district");
        Apartment existingApartment = new Apartment(apartmentId, "origin address", "origin district");
        when(repository.findOne(apartmentId)).thenReturn(existingApartment);

        service.update(request);

        verify(repository).saveAndFlush(captorApartment.capture());
        Apartment updatedApartment = captorApartment.getValue();

        assertEquals(updatedApartment.getApartmentId(), apartmentId);
        assertEquals(updatedApartment.getAddress(), "new address");
        assertEquals(updatedApartment.getDistrict(), "new district");
    }

    @Test
    void should_update_apartment_fail_when_not_find_existed() {
        int apartmentId = 123;
        ApartmentRequest request = new ApartmentRequest(apartmentId, "new address", "new district");
        when(repository.findOne(apartmentId)).thenReturn(null);

        ResourceNotFoundException exception =
                assertThrows(ResourceNotFoundException.class, () -> service.update(request));
        assertEquals(exception.getMessage(), "Your Apartment (123) is not found");
    }

    @Test
    void should_delete_apartment_success_when_apartment_existed() throws Exception, ResourceNotFoundException {
        int apartmentId = 123;
        Apartment existingApartment = new Apartment(apartmentId, "origin address", "origin district");
        when(repository.findOne(apartmentId)).thenReturn(existingApartment);

        service.delete(apartmentId);

        verify(repository).delete(captorApartment.capture());
        Apartment updatedApartment = captorApartment.getValue();

        assertEquals(updatedApartment.getApartmentId(), apartmentId);
        assertEquals(updatedApartment.getAddress(), "origin address");
        assertEquals(updatedApartment.getDistrict(), "origin district");
    }

    @Test
    void should_delete_apartment_fail_when_not_find_existed() {
        int apartmentId = 123;
        when(repository.findOne(apartmentId)).thenReturn(null);

        ResourceNotFoundException exception =
                assertThrows(ResourceNotFoundException.class, () -> service.delete(apartmentId));
        assertEquals(exception.getMessage(), "Your Apartment (123) is not found");
    }

    @Test
    void should_show_apartment_success_when_apartment_existed() throws Exception, ResourceNotFoundException {
        int apartmentId = 123;
        Apartment existingApartment = new Apartment(apartmentId, "origin address", "origin district");
        when(repository.findOne(apartmentId)).thenReturn(existingApartment);

        Apartment apartment = service.show(apartmentId);

        assertEquals(apartment.getApartmentId(), apartmentId);
        assertEquals(apartment.getAddress(), "origin address");
        assertEquals(apartment.getDistrict(), "origin district");
    }

    @Test
    void should_show_apartment_fail_when_not_find_existed() {
        int apartmentId = 123;
        when(repository.findOne(apartmentId)).thenReturn(null);

        ResourceNotFoundException exception =
                assertThrows(ResourceNotFoundException.class, () -> service.show(apartmentId));
        assertEquals(exception.getMessage(), "Your Apartment (123) is not found");
    }
}