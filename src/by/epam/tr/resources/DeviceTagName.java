package by.epam.tr.resources;

public enum DeviceTagName {
    DEVICES("devices"),
    ID("id"),
    NAME("name"),
    ORIGIN("origin"),
    PRICE("price"),
    ADDRESS("address"),
    CRITICAL("critical"),
    DEVICE("device"),
    TC_DEVICES("tc_devices"),
    CITY("city"),
    COUNTRY("country"),
    STREET("street"),
    TYPE("type"),
    DEFAULT_TYPE("home");

    private String value;

    private DeviceTagName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
