package com.ryanmichela.horsebreeding;

import com.ryanmichela.horsebreeding.genetics.Chromosome;
import com.ryanmichela.horsebreeding.genetics.Gamete;
import com.ryanmichela.horsebreeding.genetics.Zygote;
import org.bukkit.entity.Horse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rmichela on 5/19/16.
 */
public class GeneticStore {
    private Map<Integer, Zygote> geneMap = new HashMap<>();

    public Zygote discover(Horse horse) {
        if (!geneMap.containsKey(horse.getEntityId())) {
            Randomable rnd = new RealRandom(horse.getWorld().getSeed());

            Gamete gp1 = new Gamete(Chromosome.randomChromosome(rnd), Chromosome.randomChromosome(rnd), Chromosome.randomChromosome(rnd));
            Gamete gp2 = new Gamete(Chromosome.randomChromosome(rnd), Chromosome.randomChromosome(rnd), Chromosome.randomChromosome(rnd));

            Zygote z = new Zygote(gp1, gp2);
            geneMap.put(horse.getEntityId(), z);
            return z;
        } else {
            return geneMap.get(horse.getEntityId());
        }
    }

    public Zygote breed(Horse father, Horse mother, Horse child) {
        Randomable rnd = new RealRandom(father.getWorld().getSeed());

        List<Gamete> sperm = discover(father).meios(rnd);
        List<Gamete> eggs = discover(mother).meios(rnd);

        Zygote z = Gamete.mate(sperm, eggs, rnd).mutate();
        geneMap.put(child.getEntityId(), z);
        return z;
    }
}
