package net.canelex.narutorunmod.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.*;

public class BipedTransformer implements IClassTransformer
{
	@Override public byte[] transform(String name, String transformedName, byte[] bytes)
	{
		if (transformedName.equals("net.minecraft.client.model.ModelBiped"))
		{
			ClassReader reader = new ClassReader(bytes);
			ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
			ClassVisitor visitor = new ClassVisitor(Opcodes.ASM4, writer)
			{
				@Override public MethodVisitor visitMethod(int access, String name, String desc, String sig, String[] ex)
				{
					MethodVisitor mv = super.visitMethod(access, name, desc, sig, ex);

					// (FFFFFFLnet/minecraft/entity/Entity;)V - Unobfuscated description
					if (desc.equals("(FFFFFFLpk;)V") && name.equals("a")) //setRotationAngles
					{
						return new RotationAnglesVisitor(mv);
					}

					return mv;
				}
			};

			reader.accept(visitor, 0);
			return writer.toByteArray();
		}

		return bytes;
	}
}
