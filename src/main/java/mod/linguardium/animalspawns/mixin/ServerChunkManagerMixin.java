package mod.linguardium.animalspawns.mixin;

import mod.linguardium.animalspawns.NewGameRules;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

import static net.minecraft.world.SpawnHelper.spawn;

@Mixin(ServerChunkManager.class)
public abstract class ServerChunkManagerMixin {
    @Shadow public abstract World getWorld();

    @ModifyConstant(method="tickChunks",constant=@Constant(longValue=400L))
    private long AnimalSpawnTimeDelayModifier(long originalDelay) {
        long interval = getWorld().getGameRules().getInt(NewGameRules.ANIMAL_TIME_INTERVAL_KEY);
        if (interval < 1)
            interval = 1;
        return interval;
    }

}
