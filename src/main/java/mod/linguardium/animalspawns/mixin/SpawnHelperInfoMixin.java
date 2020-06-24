package mod.linguardium.animalspawns.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import mod.linguardium.animalspawns.helpers.SpawnHelperInfoInterface;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SpawnHelper.Info.class)
public abstract class SpawnHelperInfoMixin implements SpawnHelperInfoInterface {
    @Shadow protected abstract boolean isBelowCap(SpawnGroup group);

    @Shadow
    @Final
    private int spawningChunkCount;

    @Shadow
    @Final
    private Object2IntOpenHashMap<SpawnGroup> groupToCount;

    @Shadow
    protected abstract boolean test(EntityType<?> type, BlockPos pos, Chunk chunk);
    @Shadow
    protected abstract void run(MobEntity entity, Chunk chunk);

    @Override
    public boolean AnimalSpawns_checkBelowMobCap(SpawnGroup spawnGroup) {
        return isBelowCap(spawnGroup);
    }

    public boolean isBelowCap_CustomCapacity(SpawnGroup group, int capacity, int chunkArea) {
        int i = capacity * this.spawningChunkCount / chunkArea;
        return this.groupToCount.getInt(group) < i;
    }

    @Override
    public boolean PublicTest(EntityType<?> type, BlockPos pos, Chunk chunk) {
        return this.test(type,pos,chunk);
    }

    @Override
    public void PublicRun(MobEntity entity, Chunk chunk) {
        this.run(entity,chunk);
    }
}
