package com.ryanmichela.horsebreeding.genetics;

import com.ryanmichela.horsebreeding.Randomable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Copyright 2014 Ryan Michela
 */
public class Zygote implements Serializable {
    private static final long serialVersionUID = -6837983940339034511L;
    private final Gamete p1;
    private final Gamete p2;


    public Zygote(Gamete p1, Gamete p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public List<Gamete> meios(Randomable rnd) {
        // Meiosis I - Perform crossover
        Cromatid p1a = new Cromatid(p1.getA());
        Cromatid p2a = new Cromatid(p2.getA());
        Cromatid.crossover(p1a, p2a, rnd);

        Cromatid p1b = new Cromatid(p1.getB());
        Cromatid p2b = new Cromatid(p2.getB());
        Cromatid.crossover(p1b, p2b, rnd);

        Cromatid p1c = new Cromatid(p1.getC());
        Cromatid p2c = new Cromatid(p2.getC());
        Cromatid.crossover(p1c, p2c, rnd);

        // Meiosis II - Generate gametes
        List<Gamete> gametes = new ArrayList<Gamete>(64);
        for(int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 1; k++) {
                    Cromatid cra = i == 0 ? p1a : p2a;
                    Cromatid crb = j == 0 ? p1a : p2b;
                    Cromatid crc = k == 0 ? p1c : p2c;

                    gametes.add(new Gamete(cra.getC1(), crb.getC1(), crc.getC1()));
                    gametes.add(new Gamete(cra.getC1(), crb.getC1(), crc.getC2()));
                    gametes.add(new Gamete(cra.getC1(), crb.getC2(), crc.getC1()));
                    gametes.add(new Gamete(cra.getC1(), crb.getC2(), crc.getC2()));
                    gametes.add(new Gamete(cra.getC2(), crb.getC1(), crc.getC1()));
                    gametes.add(new Gamete(cra.getC2(), crb.getC1(), crc.getC2()));
                    gametes.add(new Gamete(cra.getC2(), crb.getC2(), crc.getC1()));
                    gametes.add(new Gamete(cra.getC2(), crb.getC2(), crc.getC2()));
                }
            }
        }

        return gametes;
    }

    public Zygote mutate() {
        p1.mutate();
        p2.mutate();
        return this;
    }

    @Override
    public String toString() {
        return p1.toString() + " :: " + p2.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zygote zygote = (Zygote) o;

        if (!p1.equals(zygote.p1)) return false;
        return p2.equals(zygote.p2);

    }

    @Override
    public int hashCode() {
        int result = p1.hashCode();
        result = 31 * result + p2.hashCode();
        return result;
    }
}
