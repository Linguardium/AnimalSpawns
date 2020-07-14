package mod.linguardium.animalspawns.mixin;

import mod.linguardium.animalspawns.NewGameRules;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends Entity {

    public MobEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }
    @ModifyVariable(at=@At(value="INVOKE_ASSIGN",target="Lnet/minecraft/entity/SpawnGroup;getImmediateDespawnRange()I",shift = At.Shift.AFTER),method="checkDespawn")
    private int MaxDespawnRangeModifier(int old) {
        if (this.getType().getSpawnGroup().equals(SpawnGroup.CREATURE)) {
            return world.getGameRules().getInt(NewGameRules.ANIMAL_HARD_DESPAWN_DISTANCE_KEY);
        }
        return old;
    }
    @ModifyVariable(at=@At(value="INVOKE_ASSIGN",target="Lnet/minecraft/entity/SpawnGroup;getDespawnStartRange()I",shift = At.Shift.AFTER),method="checkDespawn")
    private int MinDespawnRangeModifier(int old) {
        if (this.getType().getSpawnGroup().equals(SpawnGroup.CREATURE)) {
            return world.getGameRules().getInt(NewGameRules.ANIMAL_SOFT_DESPAWN_DISTANCE_KEY);
        }
        return old;
    }
}
