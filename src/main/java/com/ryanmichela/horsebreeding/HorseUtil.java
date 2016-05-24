package com.ryanmichela.horsebreeding;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Horse;

/**
 * Created by rmichela on 5/21/16.
 */
public class HorseUtil {
    public static void setHorseSpeed(Horse horse, double speed) {
        horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
    }

    public static void setHorseJumpStrength(Horse horse, double jumpStrength) {
        horse.setJumpStrength(jumpStrength);
    }

    public static void setHorseHealth(Horse horse, double maxHealth) {
        horse.setMaxHealth(maxHealth);
    }
}
