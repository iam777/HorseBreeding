package com.ryanmichela.horsebreeding.genetics;

import java.util.List;
import java.util.Random;

/**
 * Copyright 2014 Ryan Michela
 */
public class Gamete {
    private final Chromosome a;
    private final Chromosome b;
    private final Chromosome c;

    public Gamete(Chromosome a, Chromosome b, Chromosome c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Chromosome getA() {
        return a;
    }

    public Chromosome getB() {
        return b;
    }

    public Chromosome getC() {
        return c;
    }

    public Zygote mate(List<Gamete> p1s, List<Gamete> p2s) {
        Random rnd = new Random();
        Gamete p1 = p1s.get(rnd.nextInt(p1s.size()));
        Gamete p2 = p2s.get(rnd.nextInt(p2s.size()));
        return new Zygote(p1, p2);
    }
}
