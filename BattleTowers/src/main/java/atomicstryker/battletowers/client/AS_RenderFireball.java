package atomicstryker.battletowers.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;

public class AS_RenderFireball extends Render<Entity>
{

    private float scale;

    public AS_RenderFireball(RenderManager mgr, float par1)
    {
    	super(mgr);
        this.scale = par1;
    }

	@Override
    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(entity);
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(this.scale, this.scale, this.scale);
        TextureAtlasSprite textureatlassprite = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(Items.fire_charge);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        float f = textureatlassprite.getMinU();
        float f1 = textureatlassprite.getMaxU();
        float f2 = textureatlassprite.getMinV();
        float f3 = textureatlassprite.getMaxV();
        GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181710_j);
        worldrenderer.func_181662_b(-0.5D, -0.25D, 0.0D).func_181673_a((double)f, (double)f3).func_181663_c(0.0F, 1.0F, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0.5D, -0.25D, 0.0D).func_181673_a((double)f1, (double)f3).func_181663_c(0.0F, 1.0F, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0.5D, 0.75D, 0.0D).func_181673_a((double)f1, (double)f2).func_181663_c(0.0F, 1.0F, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(-0.5D, 0.75D, 0.0D).func_181673_a((double)f, (double)f2).func_181663_c(0.0F, 1.0F, 0.0F).func_181675_d();
        tessellator.draw();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return TextureMap.locationBlocksTexture;
    }
    
}
