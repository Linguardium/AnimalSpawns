package mod.linguardium.animalspawns.mixin;

import mod.linguardium.animalspawns.NewGameRules;
import mod.linguardium.animalspawns.helpers.SpawnHelperInfoInterface;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.world.SpawnHelper.spawnEntitiesInChunk;

@Mixin(SpawnHelper.class)
public class SpawnHelperMixin {

    @Shadow
    @Final
    private static int CHUNK_AREA;


    @Redirect(at=@At(value="INVOKE", target="net/minecraft/world/SpawnHelper$Info.method_27829(Lnet/minecraft/world/SpawnHelper$Info;Lnet/minecraft/entity/SpawnGroup;)Z"), method="spawn")
    private static boolean VerifyMobsBelowCount(SpawnHelper.Info helperinfo, SpawnGroup group) {
        if (group.equals(SpawnGroup.CREATURE))
        {
            return false;
        }else{
            return ((SpawnHelperInfoInterface)helperinfo).AnimalSpawns_checkBelowMobCap(group);
        }
    }
    @Inject(at=@At(value="INVOKE",target="Lnet/minecraft/util/profiler/Profiler;pop()V"),method="spawn")
    private static void spawnCREATURE_group(ServerWorld world, WorldChunk chunk, SpawnHelper.Info helperInfo, boolean spawnAnimals, boolean spawnMonsters, boolean shouldSpawnAnimals, CallbackInfo info) {
        SpawnGroup spawnGroup = SpawnGroup.CREATURE;
        int CreatureMobCapRule = world.getGameRules().getInt(NewGameRules.ANIMAL_MOB_CAP_KEY);
        if ((spawnAnimals || !spawnGroup.isPeaceful()) && (spawnMonsters || spawnGroup.isPeaceful()) && (shouldSpawnAnimals || !spawnGroup.isAnimal()) && ((SpawnHelperInfoInterface)helperInfo).isBelowCap_CustomCapacity(spawnGroup,CreatureMobCapRule,CHUNK_AREA)) {
            spawnEntitiesInChunk(spawnGroup, world, chunk, ((SpawnHelperInfoInterface) helperInfo)::PublicTest, ((SpawnHelperInfoInterface) helperInfo)::PublicRun);
        }
    }
}
