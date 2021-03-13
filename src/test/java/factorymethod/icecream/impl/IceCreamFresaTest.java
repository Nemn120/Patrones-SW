package factorymethod.icecream.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IceCreamFresaTest {

    IceCreamFresa iceCreamFresa;

    @Before
    public void before() {
        iceCreamFresa=new IceCreamFresa();
    }

    @Test
    public void testPrepareIceCream() {

        iceCreamFresa.prepareIceCream();

        Assert.assertEquals("crema batida espesa, leche condensada azucarada y extracto de fresa",
                iceCreamFresa.getIngredientes());
        Assert.assertSame("crema batida espesa, leche condensada azucarada y extracto de fresa",
                iceCreamFresa.getIngredientes());
        Assert.assertEquals("Fresa",iceCreamFresa.getFlavors());
        Assert.assertSame("Fresa",iceCreamFresa.getFlavors());

    }

    @Test
    public void testSetTopping() {

        iceCreamFresa.setTopping("Toppings");
        Assert.assertEquals("Toppings",iceCreamFresa.getToppings());
        Assert.assertSame("Toppings",iceCreamFresa.getToppings());

    }


}