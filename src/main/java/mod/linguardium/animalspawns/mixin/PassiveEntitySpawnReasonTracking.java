package mod.linguardium.animalspawns.mixin;

import jdk.internal.jline.internal.Nullable;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntityWithAi;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PassiveEntity.class)
public class PassiveEntitySpawnReasonTracking extends MobEntityWithAi {
    protected PassiveEntitySpawnReasonTracking(EntityType<? extends MobEntityWithAi> entityType, World world) {
        super(entityType, world);
    }

/*    @Inject(at=@At("TAIL"),method="initialize")
    private void AnimalSpawns_initialize(WorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CompoundTag entityTag, CallbackInfoReturnable<Void> info) {
        if (spawnReason.equals(SpawnReason.BREEDING))
            this.setPersistent();
    }*/
}
