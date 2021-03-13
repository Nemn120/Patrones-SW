package factorymethod.icecream;

public abstract class GenericIceCream {
	private String ingredientes;
	protected String toppings;
	private double price;
	protected String flavors;

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

	protected void createIceCream(){
		System.out.println("El helado de "+flavors+" se prepara con el siguiente ingrediente:" + ingredientes
				+ (toppings != null && !toppings.isEmpty() ? (", adicionales: " + toppings)
				: " sin adicional"));
	}

}
