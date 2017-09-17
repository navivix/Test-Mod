package navivix.testmod.blocks;

import navivix.testmod.tileentities.TEBlinker;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class BlockBlinker extends ModBContainer
{
    public static final PropertyBool LIT = PropertyBool.create("lit");

    public BlockBlinker()
    {
        super("blinker", Material.GLASS);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TEBlinker();
    }

    private TEBlinker getTE(IBlockAccess world, BlockPos pos)
    {
        return (TEBlinker) world.getTileEntity(pos);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(LIT, getTE(worldIn, pos).isLit());
    }

    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, LIT);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
}
