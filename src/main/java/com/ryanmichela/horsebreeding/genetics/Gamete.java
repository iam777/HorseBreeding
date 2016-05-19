package com.ryanmichela.horsebreeding.genetics;

import com.ryanmichela.horsebreeding.Randomable;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright 2014 Ryan Michela
 */
public class Gamete implements Serializable {
    private static final long serialVersionUID = 628134360327318386L;
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

    public static Zygote mate(List<Gamete> p1s, List<Gamete> p2s, Randomable rnd) {
        Gamete p1 = p1s.get(rnd.nextInt(p1s.size()));
        Gamete p2 = p2s.get(rnd.nextInt(p2s.size()));
        return new Zygote(p1, p2);
    }

    @Override
    public String toString() {
        return a.toString() + " / " + b.toString() + " / " + c.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gamete gamete = (Gamete) o;

        if (!getA().equals(gamete.getA())) return false;
        if (!getB().equals(gamete.getB())) return false;
        return getC().equals(gamete.getC());

    }

    @Override
    public int hashCode() {
        int result = getA().hashCode();
        result = 31 * result + getB().hashCode();
        result = 31 * result + getC().hashCode();
        return result;
    }
}
