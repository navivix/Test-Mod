package navivix.testmod.handlers;

import navivix.testmod.init.MBlocks;
import navivix.testmod.init.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class RegistrationHandler
{
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        // Registering items
        event.getRegistry().registerAll(MItems.getItems());

        // Registering ItemBlocks
        for(Block block : MBlocks.getBlocks())
        {
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(MBlocks.getBlocks());
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void regModels(ModelRegistryEvent event)
    {
        // Registering models for items
        for(Item item : MItems.getItems())
        {
            regModel(item);
        }

        // Registering models for blocks
        for (Block block : MBlocks.getBlocks())
        {
            regModel(Item.getItemFromBlock(block));
        }
    }

    @SideOnly(Side.CLIENT)
    private static void regModel(Item item)
    {
        regModel(item, 0);
    }

    @SideOnly(Side.CLIENT)
    private static void regModel(Item item, int meta)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
