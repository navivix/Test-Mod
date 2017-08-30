package navivix.testmod.init;

import navivix.testmod.items.ItemIPhone;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class MItems
{
    public static List<Item> ITEMS = new ArrayList<Item>();

    public static final ItemIPhone iphone;

    static
    {
        addItem(iphone = new ItemIPhone("iphone"));
    }

    private static void addItem(Item item)
    {
        ITEMS.add(item);
    }

    public static Item[] getItems()
    {
        return ITEMS.toArray(new Item[ITEMS.size()]);
    }
}
