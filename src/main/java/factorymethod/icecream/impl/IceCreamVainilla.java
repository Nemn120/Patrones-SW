package factorymethod.icecream.impl;

import factorymethod.icecream.GenericIceCream;
import factorymethod.icecream.IceCreamMachine;

public class IceCreamVainilla extends GenericIceCream<IceCreamVainilla> implements IceCreamMachine {

	public IceCreamVainilla() {
		this.setIngredientes("leche entera, almidón de maíz + 2 cucharadas de leche, extracto de vainilla y azúcar");		
	}
	
	@Override
	public void prepareIceCream() {
		System.out.println("El helado de vainilla se prepara con el siguiente ingrediente:" + this.getIngredientes()
				+ (this.getToppings() != null && !this.getToppings().isEmpty() ? (" and with toppings " + this.getToppings())
						: " y sin cobertura"));
	}

	public void setTopping(String toppings) {
		this.setTopping(toppings);
		
	}

}
