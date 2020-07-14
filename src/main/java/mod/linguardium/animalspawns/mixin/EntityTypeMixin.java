package mod.linguardium.animalspawns.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(EntityType.class)
public class EntityTypeMixin {

    @Redirect(at=@At(value="FIELD",opcode = Opcodes.GETSTATIC,target="net/minecraft/entity/SpawnGroup.CREATURE:Lnet/minecraft/entity/SpawnGroup;", ordinal = 0),method="<clinit>()V")
    private static SpawnGroup BeesAreAmbient() {
        return SpawnGroup.MISC;
    }


}
