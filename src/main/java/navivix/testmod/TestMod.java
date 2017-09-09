package navivix.testmod;

import navivix.testmod.tileentities.TECounter;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
@Mod(modid = TestMod.MODID, name = TestMod.NAME, version = TestMod.VERSION)
public class TestMod
{
    public static final String MODID = "testmod";
    public static final String NAME = "Test Mod";
    public static final String VERSION = "@VERSION@";

    @Mod.Instance
    public static TestMod instance;

    public static final CreativeTabs TAB = new CreativeTabs("test_tab")
    {
        @SideOnly(Side.CLIENT)
        @Override
        public Item getTabIconItem()
        {
            return Items.FILLED_MAP;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        GameRegistry.registerTileEntity(TECounter.class, "tecounter");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
