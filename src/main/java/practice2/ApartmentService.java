package practice2;

public class ApartmentService {
    private final ApartmentRepository repository;

    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public void update(ApartmentRequest request) throws ResourceNotFoundException, Exception {
        int apartmentId = request.getApartmentId();
        Apartment existingApartment = repository.findOne(apartmentId);
        if (existingApartment == null) {
            throw new ResourceNotFoundException("Your Apartment (" + apartmentId +") is not found");
        }

        Apartment updatedApartment = existingApartment.update(request);
        repository.saveAndFlush(updatedApartment);
    }

    public void delete(int apartmentId) throws Exception, ResourceNotFoundException {
        Apartment existingApartment = repository.findOne(apartmentId);
        if (existingApartment == null) {
            throw new ResourceNotFoundException("Your Apartment (" + apartmentId +") is not found");
        }

        repository.delete(existingApartment);
    }

    public Apartment show(int apartmentId) throws ResourceNotFoundException {
        Apartment existingApartment = repository.findOne(apartmentId);
        if (existingApartment == null) {
            throw new ResourceNotFoundException("Your Apartment (" + apartmentId +") is not found");
        }

        return existingApartment;
    }
}
