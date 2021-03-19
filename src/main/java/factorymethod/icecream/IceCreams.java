package factorymethod.icecream;

import factorymethod.icecream.impl.IceCreamFresa;
import factorymethod.icecream.impl.IceCreamVainilla;
import factorymethod.icecream.impl.IcreCreamChocolate;

import java.util.ArrayList;
import java.util.List;

public class IceCreams {

    private String id;
    private Integer countTotal = 0;
    private Double totalPrice = 0.0;
    private Integer countFresa = 0;
    private Double totalPriceFresa = 0.0;
    private Integer countVainilla = 0;
    private Double totalPriceVainilla = 0.0;
    private Integer countChocolate = 0;
    private Double totalPriceChocolate = 0.0;

    private List<GenericIceCream> iceCreamList;

    public IceCreams() {
        this.iceCreamList = new ArrayList<>();
    }

    public IceCreams(List<GenericIceCream> iceCreamList) {
        this.iceCreamList = iceCreamList;
    }

    public List<GenericIceCream> getIceCreamList() {
        return iceCreamList;
    }

    public void setIceCreamList(List<GenericIceCream> iceCreamList) {
        this.iceCreamList = iceCreamList;
    }

    public void addIceCream(GenericIceCream iceCream) {
        if (iceCream instanceof IceCreamFresa) {
            totalPriceFresa += iceCream.getPrice();
            countFresa += 1;
        }
        if (iceCream instanceof IcreCreamChocolate) {
            totalPriceChocolate += iceCream.getPrice();
            countChocolate += 1;
        }
        if (iceCream instanceof IceCreamVainilla) {
            totalPriceVainilla += iceCream.getPrice();
            countVainilla += 1;
        }
        this.totalPrice += iceCream.getPrice();
        this.countTotal += 1;
        this.iceCreamList.add(iceCream);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalPriceFresa() {
        return totalPriceFresa;
    }

    public void setTotalPriceFresa(Double totalPriceFresa) {
        this.totalPriceFresa = totalPriceFresa;
    }

    public Double getTotalPriceVainilla() {
        return totalPriceVainilla;
    }

    public void setTotalPriceVainilla(Double totalPriceVainilla) {
        this.totalPriceVainilla = totalPriceVainilla;
    }

    public Double getTotalPriceChocolate() {
        return totalPriceChocolate;
    }

    public void setTotalPriceChocolate(Double totalPriceChocolate) {
        this.totalPriceChocolate = totalPriceChocolate;
    }

    public Integer getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Integer countTotal) {
        this.countTotal = countTotal;
    }

    public Integer getCountFresa() {
        return countFresa;
    }

    public void setCountFresa(Integer countFresa) {
        this.countFresa = countFresa;
    }

    public Integer getCountVainilla() {
        return countVainilla;
    }

    public void setCountVainilla(Integer countVainilla) {
        this.countVainilla = countVainilla;
    }

    public Integer getCountChocolate() {
        return countChocolate;
    }

    public void setCountChocolate(Integer countChocolate) {
        this.countChocolate = countChocolate;
    }

    @Override
    public String toString() {
        return "Helados {" +
                "id='" + id + '\'' +
                "\n Cantidad total=" + countTotal +
                "\n Precio total=" + totalPrice +
                "\n Cantidad total Fresa=" + countFresa +
                "\n Precio total Fresa=" + totalPriceFresa +
                "\n Cantidad total Vainilla=" + countVainilla +
                "\n Precio total Vainilla=" + totalPriceVainilla +
                "\n Precio total Chocolate=" + totalPriceChocolate +
                "\n Cantidad total Chocolate=" + countChocolate +
                '}';
    }
}
