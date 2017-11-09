package net.canelex.narutorunmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.ModMetadata;

import java.util.Collections;

public class NarutoRunMod extends DummyModContainer
{
	private static Minecraft mc = Minecraft.getMinecraft();

	public NarutoRunMod()
	{
		super (new ModMetadata());

		ModMetadata meta = getMetadata();
		meta.modId = "narutorunmod";
		meta.name = "Naruto Run Mod";
		meta.url = "www.youtube.com/canelex";
		meta.description = "Makes you go possibly 100 times faster.";
		meta.authorList = Collections.singletonList("canelex");
	}

	public static void setRotationAngles(ModelBiped biped, Entity e)
	{
		// Change angles to make it look like you're naruto running.
		if (NarutoRunMod.isNarutoRunning(e))
		{
			biped.bipedRightArm.rotateAngleX = (float) Math.toRadians(85);
			biped.bipedLeftArm.rotateAngleX = (float) Math.toRadians(85);
			biped.bipedBody.rotateAngleX += (float) Math.toRadians(20);
			biped.bipedRightLeg.rotationPointZ = 20 / 6F;
			biped.bipedLeftLeg.rotationPointZ = 20 / 6F;
		}
	}

	public static boolean isNarutoRunning(Entity e)
	{
		if (e.equals(mc.thePlayer))
		{
			if (e.isSprinting() && mc.gameSettings.thirdPersonView > 0)
			{
				return true;
			}
		}

		return false;
	}
}
