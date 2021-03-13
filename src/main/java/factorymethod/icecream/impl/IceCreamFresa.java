package factorymethod.icecream.impl;

import factorymethod.icecream.GenericIceCream;
import factorymethod.icecream.IceCreamMachine;

public class IceCreamFresa extends GenericIceCream<IceCreamFresa> implements IceCreamMachine {
	

	public IceCreamFresa() {
		this.setIngredientes("crema batida espesa, leche condensada azucarada, cacao en polvo sin azúcar y extracto de vainilla");
		
	}
	
	@Override
	public void prepareIceCream() {
		System.out.println("El helado de fresa se prepara con el siguiente ingrediente:" + this.getIngredientes()
				+ (this.getToppings() != null && !this.getToppings().isEmpty() ? (" and with toppings " + this.getToppings())
						: " y sin coberturas"));
		
	}

	public void setTopping(String toppings) {
		this.setTopping(toppings);
		
	}

}
