package mod.linguardium.animalspawns;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnimalSpawnsMain implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "animalspawns";
    public static final String MOD_NAME = "AnimalSpawns";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Animal Spawns Loaded");
        //TODO: Initializer
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}