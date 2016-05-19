package com.ryanmichela.horsebreeding;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by rmichela on 5/17/16.
 */
public class RealRandom implements Randomable, Serializable {
    private static final long serialVersionUID = 8550217448673135744L;
    private Random rnd;


    public RealRandom(Random rnd) {
        this.rnd = rnd;
    }

    public int nextInt(int bound) {
        return rnd.nextInt(bound);
    }

    public boolean nextBoolean() {
        return rnd.nextBoolean();
    }
}
