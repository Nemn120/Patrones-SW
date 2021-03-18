package factorymethod.icecream;

public interface IceCreamMachine extends IceCreamImage {
	
	void prepareIceCream();
	void setTopping(String toppings);
}
