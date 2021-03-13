package factorymethod.factory;

import factorymethod.icecream.IceCreamMachine;
import factorymethod.icecream.impl.IceCreamFresa;
import factorymethod.icecream.impl.IceCreamVainilla;
import factorymethod.icecream.impl.IcreCreamChocolate;

public class IceCreamFactory {
	
	public static IceCreamMachine getInstance(String type) {
		
		switch (type) {
			case "1": return new IcreCreamChocolate();
			case "2": return new IceCreamVainilla();
			case "3": return new IceCreamFresa();
		}
		return null;
		
	}


}
