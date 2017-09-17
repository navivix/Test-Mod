package navivix.testmod.gui;

import navivix.testmod.guicontainer.ContainerSafe;
import navivix.testmod.tileentities.TESafe;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiSafe extends GuiContainer
{
    private TESafe te;
    private IInventory pInv;

    public GuiSafe(IInventory playerInv, TESafe tileEntity)
    {
        super(new ContainerSafe(playerInv, tileEntity));

        te = tileEntity;
        pInv = playerInv;

        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String blockName = te.getDisplayName().getUnformattedText();
        String playerInvName = pInv.getDisplayName().getUnformattedText();
        fontRendererObj.drawString(blockName, (xSize - fontRendererObj.getStringWidth(blockName)) / 2, 6, 5592405, false);
        fontRendererObj.drawString(playerInvName, 8, ySize - 84 - 4 - 6, 5592405, false);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("minecraft", "textures/gui/container/dispenser.png"));
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }
}
