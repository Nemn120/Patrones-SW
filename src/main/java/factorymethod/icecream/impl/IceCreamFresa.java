package factorymethod.icecream.impl;

import factorymethod.icecream.GenericIceCream;
import factorymethod.icecream.IceCreamMachine;

public class IceCreamFresa extends GenericIceCream implements IceCreamMachine {
	

	public IceCreamFresa() {
		this.setIngredientes("crema batida espesa, leche condensada azucarada y extracto de fresa");
		this.flavors = "Fresa";
		this.price = 2.5;
	}
	
	@Override
	public void prepareIceCream() {
		this.createIceCream();
		
	}

	public void setTopping(String toppings) {
		this.toppings = toppings;
		
	}
}
