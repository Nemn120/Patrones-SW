package factorymethod.icecream.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IceCreamChocolateTest {
    IcreCreamChocolate iceCreamChocolate;

    @Before
    public void before() {
        iceCreamChocolate=new IcreCreamChocolate();
    }

    @Test
    public void testPrepareIceCream() {

        iceCreamChocolate.prepareIceCream();

        Assert.assertEquals("crema batida espesa, leche condensada azucarada, cacao en polvo sin azúcar",
                iceCreamChocolate.getIngredientes());
        Assert.assertSame("crema batida espesa, leche condensada azucarada, cacao en polvo sin azúcar",
                iceCreamChocolate.getIngredientes());
        Assert.assertEquals("Chocolate",iceCreamChocolate.getFlavors());
        Assert.assertSame("Chocolate",iceCreamChocolate.getFlavors());

    }

    @Test
    public void testSetTopping() {

        iceCreamChocolate.setTopping("Toppings");
        Assert.assertEquals("Toppings",iceCreamChocolate.getToppings());
        Assert.assertSame("Toppings",iceCreamChocolate.getToppings());

    }
}
