package factorymethod.icecream.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IceCreamVainillaTest {
    IceCreamVainilla iceCreamVainilla;

    @Before
    public void before() {
        iceCreamVainilla=new IceCreamVainilla();
    }

    @Test
    public void testPrepareIceCream() {

        iceCreamVainilla.prepareIceCream();

        Assert.assertEquals("leche entera, almidón de maíz + 2 cucharadas de leche, extracto de vainilla y azúcar",
                iceCreamVainilla.getIngredientes());
        Assert.assertSame("leche entera, almidón de maíz + 2 cucharadas de leche, extracto de vainilla y azúcar",
                iceCreamVainilla.getIngredientes());
        Assert.assertEquals("Vainilla",iceCreamVainilla.getFlavors());
        Assert.assertSame("Vainilla",iceCreamVainilla.getFlavors());

    }
}
