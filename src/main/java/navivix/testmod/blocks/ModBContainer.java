package navivix.testmod.blocks;

import navivix.testmod.TestMod;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;

public abstract class ModBContainer extends BlockContainer
{
    public ModBContainer(String name, Material materialIn)
    {
        super(materialIn);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(TestMod.TAB);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
}
