package by.epam.tr.device;

public class Device {
    private int Id;
    private String Name;
    private double Price;
    private String Origin;
    private String Type;
    private Boolean Critical;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (Id != device.Id) return false;
        if (Price != device.Price) return false;
        if (Name != null ? !Name.equals(device.Name) : device.Name != null) return false;
        if (Origin != null ? !Origin.equals(device.Origin) : device.Origin != null) return false;
        if (Type != null ? !Type.equals(device.Type) : device.Type != null) return false;
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
        result = 31 * result + (Type != null ? Type.hashCode() : 0);
        result = 31 * result + (Critical != null ? Critical.hashCode() : 0);
        return result;
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
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
                ", Type='" + Type + '\'' +
                ", Critical=" + Critical +
                '}';
    }
}
