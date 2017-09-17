package navivix.testmod.init;

import navivix.testmod.tileentities.TEBlinker;
import navivix.testmod.tileentities.TECounter;
import navivix.testmod.tileentities.TESafe;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTileEntities
{
    public static void init()
    {
        reg(TECounter.class, "counter");
        reg(TEBlinker.class, "blinker");
        reg(TESafe.class, "safe");
    }

    private static void reg(Class<? extends TileEntity> file, String id)
    {
        GameRegistry.registerTileEntity(file, id);
    }
}
