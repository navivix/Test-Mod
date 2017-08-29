package navivix.testmod.items;

import navivix.testmod.TestMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemController
{
    public static Item testItem;

    public static void preInit()
    {
        testItem = new Item().setUnlocalizedName("test_item").setCreativeTab(TestMod.tabTest).setRegistryName("test_item");

        registerItems();
    }

    public static void registerItems()
    {
        //GameRegistry.register(testItem, new ResourceLocation(TestMod.MODID, "test_item"));
        GameRegistry.register(testItem);
    }

    public static void registerRenders()
    {
        registerRender(testItem);
    }

    public static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
