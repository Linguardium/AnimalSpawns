package mod.linguardium.animalspawns.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.UUID;

import static mod.linguardium.animalspawns.NewGameRules.ANIMAL_FEEDING_MAKES_PERSISTENT;
import static mod.linguardium.animalspawns.NewGameRules.ANIMAL_FEEDING_MAKES_PERSISTENT_KEY;

@Mixin(AnimalEntity.class)
public abstract class AnimalEntityMixin extends PassiveEntity {


    @Shadow private UUID lovingPlayer;

    protected AnimalEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at=@At("RETURN"),method="canImmediatelyDespawn", cancellable = true)
    private void AnimalsDespawn(CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(
                !this.isPersistent() && !this.cannotDespawn() && (world.getGameRules().getBoolean(ANIMAL_FEEDING_MAKES_PERSISTENT_KEY) && this.lovingPlayer==null)
        );
    }
    @Inject(at=@At(value="INVOKE",target="Lnet/minecraft/entity/player/PlayerEntity;getUuid()Ljava/util/UUID;"), method="lovePlayer")
    private void LoveLastsForever(CallbackInfo info) {
        if (world.getGameRules().getBoolean(ANIMAL_FEEDING_MAKES_PERSISTENT_KEY))
            this.setPersistent();
    }
    @Inject(at=@At(value="INVOKE",target="Lnet/minecraft/entity/passive/PassiveEntity;setBaby(Z)V"),method="breed", locals = LocalCapture.CAPTURE_FAILHARD)
    private void ChildrenAreForever(World world, AnimalEntity partner, CallbackInfo info, PassiveEntity baby) {
        baby.setPersistent();
    }

}
