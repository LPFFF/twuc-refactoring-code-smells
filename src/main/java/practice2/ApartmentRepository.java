package practice2;

public class ApartmentRepository {
    public Apartment findOne(int apartmentId) {
        return null;
    }

    public void saveAndFlush(Apartment apartment) throws Exception {
        throw new Exception("save and flush");
    }

    public void delete(Apartment apartment) throws Exception {
        throw new Exception("delete");
    }
}
