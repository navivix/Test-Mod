package navivix.testmod.blocks;

import navivix.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlock extends Block
{
    public ModBlock(String name, Material materialIn)
    {
        super(materialIn);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(TestMod.TAB);
    }
}
