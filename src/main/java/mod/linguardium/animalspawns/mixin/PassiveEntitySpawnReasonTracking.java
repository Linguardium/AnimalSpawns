package mod.linguardium.animalspawns.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PassiveEntity.class)
public class PassiveEntitySpawnReasonTracking extends PathAwareEntity {
    protected PassiveEntitySpawnReasonTracking(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

/*    @Inject(at=@At("TAIL"),method="initialize")
    private void AnimalSpawns_initialize(WorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CompoundTag entityTag, CallbackInfoReturnable<Void> info) {
        if (spawnReason.equals(SpawnReason.BREEDING))
            this.setPersistent();
    }*/
}
