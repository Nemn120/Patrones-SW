package factorymethod.icecream;

import factorymethod.aditional.GenericAdditional;

public abstract class GenericIceCream {
	protected String flavors;
	protected double price;
	protected String ingredientes;
	protected GenericAdditional additional;

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

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
		System.out.println("El helado de "+flavors+" se prepara con el siguiente ingrediente: \n" + ingredientes
				+ (additional != null ? ("\n adicionales: " + additional.getName() + " - precio: "+additional.getPrice())
				: " sin adicional"));
	}

	public void addAdditional(GenericAdditional additional){
		this.price+=additional.getPrice();
		this.additional = additional;
	}
}
