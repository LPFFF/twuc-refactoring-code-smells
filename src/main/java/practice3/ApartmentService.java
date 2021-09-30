package practice3;

public class ApartmentService {
    private final ApartmentRepository repository;

    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public void update(ApartmentRequest request) throws ResourceNotFoundException, Exception {
        Apartment existingApartment = repository.findOne(request.getApartmentId());
        if (existingApartment == null) {
            throw new ResourceNotFoundException("Your Apartment (" + request.getApartmentId() +") is not found");
        }

        // 此处省略300行

        Apartment updatedApartment = existingApartment.update(request);

        // 此处省略200行

        repository.saveAndFlush(updatedApartment);
    }
}
