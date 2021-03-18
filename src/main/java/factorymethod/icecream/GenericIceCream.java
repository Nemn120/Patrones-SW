package factorymethod.icecream;

import factorymethod.aditional.GenericAdditional;

public abstract class GenericIceCream {
	protected String flavors;
	protected double price;
	protected String ingredientes;
	protected String toppings;
	protected GenericAdditional additional;

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getToppings() {
		return toppings;
	}
/*
	public void setToppings(String toppings) {
		this.toppings = toppings;
	}
*/
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFlavors() {
		return flavors;
	}

	public GenericAdditional getAdditional() {
		return additional;
	}

	public void setAdditional(GenericAdditional additional) {
		this.additional = additional;
	}

	protected void createIceCream(){
		System.out.println("El helado de "+flavors+" se prepara con el siguiente ingrediente:" + ingredientes
				+ (toppings != null && !toppings.isEmpty() ? (", adicionales: " + toppings)
				: " sin adicional"));
	}



//	public abstract String savePath();

}
