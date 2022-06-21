package practice3;

public class ApartmentService {
    private final ApartmentRepository repository;
    private Apartment updatedApartment;

    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public void update(ApartmentRequest request) throws ResourceNotFoundException, Exception {
        Apartment existingApartment = repository.findOne(request.getApartmentId());
        if (existingApartment == null) {
            throw new ResourceNotFoundException("Your Apartment (" + request.getApartmentId() + ") is not found");
        }

        Apartment updatedApartment = updatedApartment(request, existingApartment);

        saveApartment(updatedApartment);
    }

    private void saveApartment(Apartment updatedApartment) throws Exception {
        // 此处省略200行

        repository.saveAndFlush(updatedApartment);
    }

    private Apartment updatedApartment(ApartmentRequest request, Apartment existingApartment) {
        // 此处省略300行

        return existingApartment.update(request);
    }
}
