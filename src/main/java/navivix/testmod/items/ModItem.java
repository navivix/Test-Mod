package navivix.testmod.items;

import navivix.testmod.TestMod;
import net.minecraft.item.Item;

public class ModItem extends Item
{
    public ModItem(String name)
    {
        this(name, 64);
    }

    public ModItem(String name, int maxStackSize)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(TestMod.TAB);

        setMaxStackSize(maxStackSize);
    }
}
