package navivix.testmod.blocks;

import navivix.testmod.TestMod;
import navivix.testmod.network.ModGuiHandler;
import navivix.testmod.tileentities.TESafe;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockSafe extends ModBContainer
{
    public BlockSafe()
    {
        super("safe", Material.ROCK);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        if(stack.hasDisplayName())
            ((TESafe) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TESafe te = (TESafe) worldIn.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(worldIn, pos, te);

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(!worldIn.isRemote)
            playerIn.openGui(TestMod.instance, ModGuiHandler.GUI_SAFE, worldIn, pos.getX(), pos.getY(), pos.getZ());

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TESafe();
    }
}
