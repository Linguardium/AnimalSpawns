package mod.linguardium.animalspawns.mixin;

import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.gen.Invoker;

import static mod.linguardium.animalspawns.NewGameRules.*;

@Mixin(GameRules.class)
public class RegisterGameRule{

    @Invoker
    public static <T extends GameRules.Rule<T>> GameRules.Key<T> callRegister(String key, GameRules.Category category, GameRules.Type<T> type) {
        throw new NotImplementedException("GameRules mixin failed");
    }
    static {
        callRegister(ANIMAL_MOB_CAP, GameRules.Category.MOBS, IntegerGameRuleAccessor.invokeCreate(15));
        callRegister(ANIMAL_SOFT_DESPAWN_DISTANCE, GameRules.Category.MOBS, IntegerGameRuleAccessor.invokeCreate(32));
        callRegister(ANIMAL_HARD_DESPAWN_DISTANCE, GameRules.Category.MOBS, IntegerGameRuleAccessor.invokeCreate(128));
        callRegister(ANIMAL_TIME_INTERVAL, GameRules.Category.MOBS, IntegerGameRuleAccessor.invokeCreate(400));
        callRegister(ANIMAL_FEEDING_MAKES_PERSISTENT, GameRules.Category.MOBS, BooleanGameRuleAccessor.invokeCreate(true));

   }
}