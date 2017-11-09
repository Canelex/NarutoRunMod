package net.canelex.narutorunmod;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

@IFMLLoadingPlugin.Name("Naruto Run Mod")
@IFMLLoadingPlugin.MCVersion("1.8.9")
public class LoadingPlugin implements IFMLLoadingPlugin
{
	@Override public String getModContainerClass()
	{
		return "net.canelex.narutorunmod.NarutoRunMod";
	}

	@Override public String[] getASMTransformerClass()
	{
		return new String[] {"net.canelex.narutorunmod.asm.BipedTransformer"};
	}

	@Override public String getAccessTransformerClass()
	{
		return null;
	}

	@Override public String getSetupClass()
	{
		return null;
	}

	@Override public void injectData(Map<String, Object> data)
	{
	}
}
