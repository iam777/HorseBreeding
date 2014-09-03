package com.ryanmichela.horsebreeding.genetics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Copyright 2014 Ryan Michela
 */
public class Chromosome {
    public static int NUMBER_OF_GENES = 24;

    private final List<Boolean> geneSequence;

    public Chromosome(List<Boolean> geneSequence) {
        this.geneSequence = Collections.unmodifiableList(geneSequence);
    }

    public static Chromosome randomChromosome() {
        Random rnd = new Random();
        List<Boolean> geneSequence = new ArrayList<Boolean>(NUMBER_OF_GENES);
        for (int i = 0; i < NUMBER_OF_GENES; i++) {
            geneSequence.add(i, rnd.nextBoolean());
        }
        return new Chromosome(geneSequence);
    }

    public List<Boolean> getGeneSequence() {
        return geneSequence;
    }
}
