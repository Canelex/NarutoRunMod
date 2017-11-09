package net.canelex.narutorunmod.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class RotationAnglesVisitor extends MethodVisitor implements Opcodes
{
	public RotationAnglesVisitor(MethodVisitor mv)
	{
		super(ASM4, mv);
	}

	@Override public void visitInsn(int opcode)
	{
		if (opcode == RETURN)
		{
			// (Lnet/minecraft/client/model/ModelBiped;Lnet/minecraft/entity/Entity;)V - Non Obfuscated
			visitVarInsn(ALOAD, 0); // Param ModelBiped (this)
			visitVarInsn(ALOAD, 7); // Param Entity
			visitMethodInsn(INVOKESTATIC, "net/canelex/narutorunmod/NarutoRunMod","setRotationAngles", "(Lbbj;Lpk;)V", false);
		}

		super.visitInsn(opcode);
	}
}
