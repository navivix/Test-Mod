package navivix.testmod.guicontainer;

import navivix.testmod.tileentities.TESafe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class ContainerSafe extends Container
{
    private TESafe te;

    public ContainerSafe(IInventory playerInv, TESafe tileEntity)
    {
        te = tileEntity;

        /*
         * SLOTS:
         *
         * Tile Entity 0-8 ........ 0  - 8
         * Player Inventory 9-35 .. 9  - 35
         * Player Inventory 0-8 ... 36 - 44
         */

        // TileEntity, Slot 0-8, Slot IDs 0-8
        for(int y = 0; y < 3; y++)
        {
            for(int x = 0; x < 3; x++)
            {
                addSlotToContainer(new Slot(te, x + y * 3, 62 + x * 18, 17 + y * 18));
            }
        }

        // Player inventory
        // Slot 9-35, IDs 9-35
        for(int y = 0; y < 3; y++)
        {
            for(int x = 0; x < 9; x++)
            {
                addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        // Slot 0-8, IDs 36-44
        for(int x = 0; x < 9; x++)
        {
            addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return te.isUseableByPlayer(playerIn);
    }

    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack previous = null;
        Slot slot = (Slot) inventorySlots.get(index);

        if(slot != null && slot.getHasStack())
        {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if(index < 9)
            {
                // From TE to Player
                if (!mergeItemStack(current, 9, 45, true))
                    return null;
            }
            else
            {
                // From Player to TE
                if(!mergeItemStack(current, 0, 9, false))
                    return null;
            }

            if(current.stackSize == 0)
                slot.putStack(null);
            else
                slot.onSlotChanged();

            if(current.stackSize == previous.stackSize)
                return null;

            slot.onPickupFromSlot(playerIn, current);
        }

        return previous;
    }
}
