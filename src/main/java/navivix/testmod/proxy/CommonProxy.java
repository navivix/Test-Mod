package navivix.testmod.proxy;

import navivix.testmod.TestMod;
import navivix.testmod.init.MRecipes;
import navivix.testmod.init.MTileEntities;
import navivix.testmod.network.ModGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy
{
    public void preInit()
    {
        MTileEntities.init();
    }

    public void init()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(TestMod.instance, new ModGuiHandler());

        MRecipes.init();
    }

    public void postInit()
    {

    }
}
