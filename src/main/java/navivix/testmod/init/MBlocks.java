package navivix.testmod.init;

import navivix.testmod.blocks.BlockBlinker;
import navivix.testmod.blocks.BlockCobbleX;
import navivix.testmod.blocks.BlockCounter;
import navivix.testmod.blocks.BlockSafe;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class MBlocks
{
    public static List<Block> BLOCKS = new ArrayList<Block>();

    public static final BlockCobbleX cobblex;
    public static final BlockCounter counter;
    public static final BlockBlinker blinker;
    public static final BlockSafe safe;

    static
    {
        addBlock(cobblex = new BlockCobbleX("cobblex", Material.ROCK));
        addBlock(counter = new BlockCounter("counter"));
        addBlock(blinker = new BlockBlinker());
        addBlock(safe = new BlockSafe());
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
