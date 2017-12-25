package by.epam.tr.device;

public class Device {
    private int Id;
    private String Name;
    private double Price;
    private String Origin;
    private Address address;
    private Boolean Critical;

    public Device() {

    }

    public Device(int id, String name, double price, String origin, Address address, Boolean critical) {
        Id = id;
        Name = name;
        Price = price;
        Origin = origin;
        this.address = address;
        Critical = critical;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getCritical() {
        return Critical;
    }

    public void setCritical(Boolean critical) {
        Critical = critical;
    }

    @Override
    public String toString() {
        return "Device{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Origin='" + Origin + '\'' +
                ", address='" + address + '\'' +
                ", Critical=" + Critical +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (Id != device.Id) return false;
        if (Double.compare(device.Price, Price) != 0) return false;
        if (Name != null ? !Name.equals(device.Name) : device.Name != null) return false;
        if (Origin != null ? !Origin.equals(device.Origin) : device.Origin != null) return false;
        if (address != null ? !address.equals(device.address) : device.address != null) return false;
        return Critical != null ? Critical.equals(device.Critical) : device.Critical == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Id;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        temp = Double.doubleToLongBits(Price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (Origin != null ? Origin.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (Critical != null ? Critical.hashCode() : 0);
        return result;
    }
}
