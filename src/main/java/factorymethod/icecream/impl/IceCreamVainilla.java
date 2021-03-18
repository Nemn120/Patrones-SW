package factorymethod.icecream.impl;

import factorymethod.icecream.GenericIceCream;
import factorymethod.icecream.IceCreamMachine;

public class IceCreamVainilla extends GenericIceCream implements IceCreamMachine {

	public IceCreamVainilla() {
		this.setIngredientes("leche entera, almidón de maíz + 2 cucharadas de leche, extracto de vainilla y azúcar");
		this.flavors = "Vainilla";
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
