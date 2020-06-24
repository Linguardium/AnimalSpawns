package mod.linguardium.animalspawns.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChickenEntity.class)
public abstract class ChickenMixin extends AnimalEntity {
    protected ChickenMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at=@At("TAIL"),method="canImmediatelyDespawn", cancellable = true)
    private void chickens_despawn_too(double d, CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(info.getReturnValueZ() || super.canImmediatelyDespawn(d));
    }
}
