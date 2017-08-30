package navivix.testmod.proxies;

import navivix.testmod.items.ItemController;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);

        ItemController.registerRenders(); // <---- correct
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);

        //ItemController.registerRenders(); <---- incorrect
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
