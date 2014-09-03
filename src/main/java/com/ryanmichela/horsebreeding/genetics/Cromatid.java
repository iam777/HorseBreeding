package com.ryanmichela.horsebreeding.genetics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Copyright 2014 Ryan Michela
 */
public class Cromatid {
    private Chromosome c1;
    private Chromosome c2;

    public Cromatid(Chromosome c) {
        this.c1 = c;
        this.c2 = c;
    }

    public Chromosome getC1() {
        return c1;
    }

    public Chromosome getC2() {
        return c2;
    }

    public static void crossover(Cromatid p1, Cromatid p2) {
        Random rnd = new Random();
        int crossoverPoint = rnd.nextInt(Chromosome.NUMBER_OF_GENES);

        List<Boolean> a = new ArrayList<Boolean>(Chromosome.NUMBER_OF_GENES);
        List<Boolean> b = new ArrayList<Boolean>(Chromosome.NUMBER_OF_GENES);
        for (int i = 0; i < Chromosome.NUMBER_OF_GENES; i++) {
            if (i < crossoverPoint) {
                a.add(i, p1.c2.getGeneSequence().get(i));
                b.add(i, p2.c1.getGeneSequence().get(i));
            } else {
                a.add(i, p2.c1.getGeneSequence().get(i));
                b.add(i, p1.c2.getGeneSequence().get(i));
            }
        }

        p1.c2 = new Chromosome(a);
        p2.c1 = new Chromosome(b);
    }
}
