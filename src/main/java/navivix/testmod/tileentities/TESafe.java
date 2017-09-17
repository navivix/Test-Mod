package navivix.testmod.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

public class TESafe extends TileEntity implements IInventory
{
    private ItemStack[] inventory;
    private String customName;

    public TESafe()
    {
        inventory = new ItemStack[getSizeInventory()];
    }

    public void setCustomName(String name)
    {
        customName = name;
    }

    public String getCustomName()
    {
        return customName;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        NBTTagList list = new NBTTagList();

        for(int i = 0; i < getSizeInventory(); i++)
        {
            if(getStackInSlot(i) != null)
            {
                NBTTagCompound stackTag = new NBTTagCompound();
                stackTag.setByte("Slot", (byte) i);
                getStackInSlot(i).writeToNBT(stackTag);
                list.appendTag(stackTag);
            }
        }

        nbt.setTag("Items", list);

        if(hasCustomName())
            nbt.setString("CustomName", getCustomName());

        return super.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        NBTTagList list = nbt.getTagList("Items", 10);

        for(int i = 0; i < list.tagCount(); i++)
        {
            NBTTagCompound stackTag = list.getCompoundTagAt(i);
            int slot = stackTag.getByte("Slot") & 255;
            setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
        }

        if(nbt.hasKey("CustomName"))
            setCustomName(nbt.getString("CustomName"));
    }

    @Override
    public boolean hasCustomName()
    {
        return customName != null && !customName.equals("");
    }

    @Override
    public String getName()
    {
        return hasCustomName() ? getCustomName() : "container.tesafe";
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName()
    {
        return hasCustomName() ? new TextComponentString(getName()) : new TextComponentTranslation(getName());
    }

    @Override
    public int getSizeInventory() {
        return 9;
    }

    @Nullable
    @Override
    public ItemStack getStackInSlot(int index)
    {
        if(index < 0 || index >= getSizeInventory())
            return null;

        return inventory[index];
    }

    @Nullable
    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        if(getStackInSlot(index) == null)
            return null;

        ItemStack itemStack;

        if(getStackInSlot(index).stackSize <= count)
        {
            itemStack = getStackInSlot(index);
            setInventorySlotContents(index, null);

            markDirty();

            return itemStack;
        }
        else
        {
            itemStack = getStackInSlot(index).splitStack(count);

            if(getStackInSlot(index).stackSize <= count)
                setInventorySlotContents(index, null);
            else
                setInventorySlotContents(index, getStackInSlot(index));

            markDirty();

            return itemStack;
        }
    }

    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack)
    {
        if(index < 0 || index >= getSizeInventory())
            return;

        if(stack != null && stack.stackSize > getInventoryStackLimit())
            stack.stackSize = getInventoryStackLimit();

        if(stack != null && stack.stackSize <= 0)
            stack = null;

        inventory[index] = stack;

        markDirty();
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        return inventory[index] = null;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return worldObj.getTileEntity(getPos()) == this && player.getDistanceSq(getPos().add(0.5, 0.5, 0.5)) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player) { }

    @Override
    public void closeInventory(EntityPlayer player) { }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) { return true; }

    @Override
    public void setField(int id, int value) { }

    @Override
    public int getField(int id) { return 0; }

    @Override
    public int getFieldCount() { return 0; }

    @Override
    public void clear()
    {
        for(int i = 0; i < getSizeInventory(); i++)
            setInventorySlotContents(i, null);
    }
}
