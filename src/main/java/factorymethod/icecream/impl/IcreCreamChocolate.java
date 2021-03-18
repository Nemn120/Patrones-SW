package factorymethod.icecream.impl;

import factorymethod.icecream.GenericIceCream;
import factorymethod.icecream.IceCreamMachine;

public class IcreCreamChocolate extends GenericIceCream implements IceCreamMachine {


	public IcreCreamChocolate() {
		this.setIngredientes("crema batida espesa, leche condensada azucarada, cacao en polvo sin azúcar");
		this.flavors = "Chocolate";
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
