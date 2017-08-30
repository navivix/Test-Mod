package navivix.testmod.items;

import navivix.testmod.TestMod;
import net.minecraft.item.Item;

public class ModItem extends Item
{
    public ModItem(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(TestMod.TAB);
    }
}
