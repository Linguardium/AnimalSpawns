package mod.linguardium.animalspawns;


import mod.linguardium.animalspawns.mixin.IntegerGameRuleAccessor;
import mod.linguardium.animalspawns.mixin.RegisterGameRule;
import net.minecraft.world.GameRules;

public class NewGameRules {
    public static String ANIMAL_MOB_CAP = "animalspawns_animalMobCap";
    public static String ANIMAL_SOFT_DESPAWN_DISTANCE = "animalspawns_animalMinDespawnDistance";
    public static String ANIMAL_HARD_DESPAWN_DISTANCE = "animalspawns_animalMaxDespawnDistance";
    public static String ANIMAL_TIME_INTERVAL = "animalspawns_animalDelaySpawn";
    public static String ANIMAL_FEEDING_MAKES_PERSISTENT = "animalspawns_feedingPersists";

    public static GameRules.Key<GameRules.IntRule> ANIMAL_MOB_CAP_KEY = new GameRules.Key<GameRules.IntRule>(ANIMAL_MOB_CAP, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> ANIMAL_SOFT_DESPAWN_DISTANCE_KEY = new GameRules.Key<GameRules.IntRule>(ANIMAL_SOFT_DESPAWN_DISTANCE, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> ANIMAL_HARD_DESPAWN_DISTANCE_KEY = new GameRules.Key<GameRules.IntRule>(ANIMAL_HARD_DESPAWN_DISTANCE, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> ANIMAL_TIME_INTERVAL_KEY = new GameRules.Key<GameRules.IntRule>(ANIMAL_TIME_INTERVAL, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.BooleanRule> ANIMAL_FEEDING_MAKES_PERSISTENT_KEY = new GameRules.Key<GameRules.BooleanRule>(ANIMAL_FEEDING_MAKES_PERSISTENT, GameRules.Category.MOBS);


    public static void init() {

    }

}
