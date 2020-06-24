package mod.linguardium.animalspawns.helpers;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public interface SpawnHelperInfoInterface {
    public boolean AnimalSpawns_checkBelowMobCap(SpawnGroup spawnGroup);
    public boolean isBelowCap_CustomCapacity(SpawnGroup group, int capacity, int chunkArea);
    public boolean PublicTest(EntityType<?> type, BlockPos pos, Chunk chunk);
    public void PublicRun(MobEntity entity, Chunk chunk);
}
