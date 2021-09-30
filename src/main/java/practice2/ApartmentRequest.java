package practice2;

public class ApartmentRequest {
    private final int apartmentId;
    private final String address;
    private final String district;


    public ApartmentRequest(int apartmentId, String address, String district) {
        this.apartmentId = apartmentId;
        this.address = address;
        this.district = district;

    }

    public int getApartmentId() {
        return apartmentId;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }
}
