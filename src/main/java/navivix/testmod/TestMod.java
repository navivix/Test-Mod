package navivix.testmod;

import navivix.testmod.items.ItemController;
import navivix.testmod.proxies.CommonProxy;
import navivix.testmod.tabs.CreativeTabTest;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TestMod.MODID, name = TestMod.NAME, version = TestMod.VERSION)
public class TestMod
{
    public static final String MODID = "testmod";
    public static final String NAME = "Test Mod";
    public static final String VERSION = "@VERSION@";

    @Mod.Instance
    public static TestMod instance;

    @SidedProxy(clientSide = "navivix.testmod.proxies.ClientProxy", serverSide = "navivix.testmod.proxies.CommonProxy")

    public static CommonProxy proxy;

    public static CreativeTabTest tabTest;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        tabTest = new CreativeTabTest(CreativeTabs.getNextID(), "tab_test");
        ItemController.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
