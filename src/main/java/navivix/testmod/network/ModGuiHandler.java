package navivix.testmod.network;

import navivix.testmod.guicontainer.ContainerSafe;
import navivix.testmod.gui.GuiSafe;
import navivix.testmod.tileentities.TESafe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler
{
    public static final int GUI_SAFE = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == GUI_SAFE)
        {
            BlockPos pos = new BlockPos(x, y, z);

            return new ContainerSafe(player.inventory, (TESafe) world.getTileEntity(pos));
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == GUI_SAFE)
        {
            BlockPos pos = new BlockPos(x, y, z);

            return new GuiSafe(player.inventory, (TESafe) world.getTileEntity(pos));
        }
        return null;
    }
}
