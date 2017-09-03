package navivix.testmod.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TECounter extends TileEntity
{
    private int counter = 0;

    public int increment()
    {
        counter++;
        markDirty();
        return counter;
    }

    public int decrement()
    {
        counter--;
        markDirty();
        return counter;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("counter", counter);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        counter = compound.getInteger("counter");
    }
}
