package practice3;

public class Apartment {
    private final int apartmentId;
    private String address;
    private String district;

    public Apartment(int apartmentId, String address, String district) {
        this.apartmentId = apartmentId;
        this.address = address;
        this.district = district;
    }

    public Apartment update(ApartmentRequest request) {
        setAddress(request.getAddress());
        setDistrict(request.getDistrict());

        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistrict(String district) {
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
