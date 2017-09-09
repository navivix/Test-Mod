package navivix.testmod.proxy;

import navivix.testmod.tileentities.TECounter;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public void preInit()
    {
        GameRegistry.registerTileEntity(TECounter.class, "counter");
    }

    public void init()
    {

    }

    public void postInit()
    {

    }
}
