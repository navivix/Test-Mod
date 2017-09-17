package navivix.testmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MRecipes
{
    private static ItemStack cobblex;

    public static void init()
    {
        cobblex = new ItemStack(MBlocks.cobblex);
        cobblex.addEnchantment(Enchantments.LURE, 1);

        GameRegistry.addShapedRecipe(cobblex,
                "AAA",
                "AAA",
                "AAA",
                'A', new ItemStack(Blocks.COBBLESTONE, 64)
        );
    }
}
