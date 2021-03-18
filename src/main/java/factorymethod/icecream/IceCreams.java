package factorymethod.icecream;

import java.util.ArrayList;
import java.util.List;

public class IceCreams {

    private String id;

    private List<GenericIceCream> iceCreamList;

    public IceCreams(){
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

    public void addIceCream(GenericIceCream iceCream){
        this.iceCreamList.add(iceCream);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
