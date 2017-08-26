package navivix.testmod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabTest extends CreativeTabs
{
    public CreativeTabTest(int index, String label) {
        super(index, label);
    }

    @Override
    public Item getTabIconItem() {
        return Items.FILLED_MAP;
    }
}
