package com.ryanmichela.horsebreeding.genetics;

import com.ryanmichela.horsebreeding.Randomable;

import java.io.Serializable;
import java.util.*;

/**
 * Copyright 2014 Ryan Michela
 */
public class Chromosome implements Serializable {
    private static final long serialVersionUID = 1554587864477651876L;
    public static int NUMBER_OF_GENES = 24;
    public static int MUTATION_PROBABILITY = 2;

    private final List<Boolean> geneSequence;
    private final Randomable rnd;

    public Chromosome(List<Boolean> geneSequence, Randomable rnd) {
        this.geneSequence = geneSequence;
        this.rnd = rnd;
    }

    public Chromosome(Boolean[] geneSequence, Randomable rnd) {
        this(Arrays.asList(geneSequence), rnd);
    }

    public void mutate() {
        if (rnd.nextInt(100) <= MUTATION_PROBABILITY) {
            int i = rnd.nextInt(NUMBER_OF_GENES);
            geneSequence.set(i, rnd.nextBoolean());
        }
    }

    public static Chromosome randomChromosome(Randomable rnd) {
        List<Boolean> geneSequence = new ArrayList<Boolean>(NUMBER_OF_GENES);
        for (int i = 0; i < NUMBER_OF_GENES; i++) {
            geneSequence.add(i, rnd.nextBoolean());
        }
        return new Chromosome(geneSequence, rnd);
    }

    public List<Boolean> getGeneSequence() {
        return Collections.unmodifiableList(geneSequence);
    }

    @Override
    public String toString() {
        return geneSequence.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chromosome that = (Chromosome) o;

        return geneSequence.equals(that.geneSequence);

    }

    @Override
    public int hashCode() {
        return geneSequence.hashCode();
    }
}
