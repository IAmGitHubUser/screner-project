package model;

//enums for charasterics name
public enum CharastericsName {
    PE_PERCENTILE_REVERSE("PE percentile  - reverse"), PRICE("price");

    private String name;

    CharastericsName(String name) {
        this.name = name;
    }

    // So that enum would be output as price and not PRICE
    @Override
    public String toString() {
        return name;
    }

}
