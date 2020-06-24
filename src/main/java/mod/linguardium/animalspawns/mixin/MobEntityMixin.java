package mod.linguardium.animalspawns.mixin;

import mod.linguardium.animalspawns.NewGameRules;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends Entity {

    public MobEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Redirect(at=@At(value="INVOKE",target="Lnet/minecraft/entity/SpawnGroup;getImmediateDespawnRange()I"),method="checkDespawn")
    private int MaxDespawnRangeModifier(SpawnGroup group) {
        return world.getGameRules().getInt(NewGameRules.ANIMAL_HARD_DESPAWN_DISTANCE_KEY);
    }
    @Redirect(at=@At(value="INVOKE",target="Lnet/minecraft/entity/SpawnGroup;getDespawnStartRange()I"),method="checkDespawn")
    private int MinDespawnRangeModifier(SpawnGroup group) {
        return world.getGameRules().getInt(NewGameRules.ANIMAL_SOFT_DESPAWN_DISTANCE_KEY);
    }
}
