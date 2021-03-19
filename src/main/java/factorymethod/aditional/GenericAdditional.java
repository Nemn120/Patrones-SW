package factorymethod.aditional;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GenericAdditional {

    protected String name;
    protected Double price;
    @JsonIgnore
    protected String type;

    public GenericAdditional() {
    }

    public GenericAdditional(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" + type + " : "+ name + '\'' +
                ", precio=" + price +
                '}';
    }
}
