package com.ryanmichela.horsebreeding;

import java.io.Serializable;

/**
 * Created by rmichela on 5/17/16.
 */
public interface Randomable {
    int nextInt(int max);
    boolean nextBoolean();
}
