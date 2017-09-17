package navivix.testmod.tileentities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;

public class TEBlinker extends TileEntity implements ITickable
{
    private boolean lit = false;

    private int counter = 0;

    private int delayCounter = 10;
    private int lastCount = 0;

    @Override
    public void update()
    {
        if(worldObj.isRemote)
        {
            updateCounter();
            counter -= lastCount * 3;

            if(counter <= 0)
            {
                lit = !lit;
                counter = 400;
                worldObj.markBlockRangeForRenderUpdate(getPos(), getPos());
            }
        }
    }

    public boolean isLit()
    {
        return lit;
    }

    private void updateCounter()
    {
        delayCounter--;

        if(delayCounter <= 0)
        {
            List<EntityLivingBase> list = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(getPos().add(-10, -10, -10), getPos().add(10, 10, 10)));
            delayCounter = 10;
            lastCount = list.size();
        }
    }
}
