package navivix.testmod.init;

import navivix.testmod.blocks.BlockCobbleX;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class MBlocks
{
    public static List<Block> BLOCKS = new ArrayList<Block>();

    public static final BlockCobbleX cobblex;

    static
    {
        addBlock(cobblex = new BlockCobbleX("cobblex", Material.ROCK));
    }

    public static void addBlock(Block block)
    {
        BLOCKS.add(block);
    }

    public static Block[] getBlocks()
    {
        return BLOCKS.toArray(new Block[BLOCKS.size()]);
    }
}
