package factorymethod.factory;

import java.util.logging.Logger;
import factorymethod.icecream.IceCreamMachine;
import factorymethod.icecream.impl.IceCreamFresa;
import factorymethod.icecream.impl.IceCreamVainilla;
import factorymethod.icecream.impl.IcreCreamChocolate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IceCreamFactoryTest {

    Logger logger;
    IceCreamMachine iceCreamMachine;

    @Before
    public  void before(){
        logger = Logger.getLogger(IceCreamFactoryTest.class.getName());
        logger.info("-------------------------------------------");
    }

    @Test
    public void testGetInstanceIcreCreamChocolate(){

        iceCreamMachine=IceCreamFactory.getInstance("1");
        logger.info("Expected: "+IcreCreamChocolate.class.getName());
        logger.info("Actual: "+iceCreamMachine.getClass().getName());
        Assert.assertTrue(iceCreamMachine instanceof IcreCreamChocolate);

    }

    @Test
    public void testGetInstanceIceCreamVainilla(){

        iceCreamMachine=IceCreamFactory.getInstance("2");
        logger.info("Expected: "+IceCreamVainilla.class.getName());
        logger.info("Actual: "+iceCreamMachine.getClass().getName());
        Assert.assertTrue(iceCreamMachine instanceof IceCreamVainilla);

    }

    @Test
    public void testGetInstanceIceCreamFresa(){

        iceCreamMachine=IceCreamFactory.getInstance("3");
        logger.info("Expected: "+IceCreamFresa.class.getName());
        logger.info("Actual: "+iceCreamMachine.getClass().getName());
        Assert.assertTrue(iceCreamMachine instanceof IceCreamFresa);

    }

    @Test
    public void testGetInstanceNull(){

        iceCreamMachine=IceCreamFactory.getInstance("4");
        logger.info("Expected: null");
        logger.info("Actual: "+iceCreamMachine);
        Assert.assertNull(iceCreamMachine );

        iceCreamMachine=IceCreamFactory.getInstance("-4");
        logger.info("Expected: null");
        logger.info("Actual: "+iceCreamMachine);
        Assert.assertNull(iceCreamMachine );

    }

}
