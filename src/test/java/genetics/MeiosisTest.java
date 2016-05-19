package genetics;

import com.ryanmichela.horsebreeding.Randomable;
import com.ryanmichela.horsebreeding.genetics.Chromosome;
import com.ryanmichela.horsebreeding.genetics.Gamete;
import com.ryanmichela.horsebreeding.genetics.Zygote;
import org.junit.Test;

import java.util.List;

/**
 * Created by rmichela on 5/17/16.
 */
public class MeiosisTest {
    @Test
    public void MeiosisShouldWork() {
        Randomable rnd = MockRandom.allZero();
        Chromosome.NUMBER_OF_GENES = 3;

        // Create P1 zygote with three chromosomes from two parents
        Chromosome p1gp1c1 = new Chromosome(new Boolean[] {false, true, true}, rnd);
        Chromosome p1gp1c2 = new Chromosome(new Boolean[] {true, false, true}, rnd);
        Chromosome p1gp1c3 = new Chromosome(new Boolean[] {false, true, false}, rnd);

        Chromosome p1gp2c1 = new Chromosome(new Boolean[] {true, true, true}, rnd);
        Chromosome p1gp2c2 = new Chromosome(new Boolean[] {true, false, false}, rnd);
        Chromosome p1gp2c3 = new Chromosome(new Boolean[] {true, true, false}, rnd);

        Zygote p1 = new Zygote(new Gamete(p1gp1c1, p1gp1c2, p1gp1c3), new Gamete(p1gp2c1, p1gp2c2, p1gp2c3));
        System.out.println("P1: " + p1);

        // Create P2 zygote with three chromosomes from two parents
        Chromosome p2gp1c1 = new Chromosome(new Boolean[] {true, false, false}, rnd);
        Chromosome p2gp1c2 = new Chromosome(new Boolean[] {false, true, false}, rnd);
        Chromosome p2gp1c3 = new Chromosome(new Boolean[] {true, false, true}, rnd);

        Chromosome p2gp2c1 = new Chromosome(new Boolean[] {false, false, false}, rnd);
        Chromosome p2gp2c2 = new Chromosome(new Boolean[] {false, true, true}, rnd);
        Chromosome p2gp2c3 = new Chromosome(new Boolean[] {false, false, true}, rnd);

        Zygote p2 = new Zygote(new Gamete(p2gp1c1, p2gp1c2, p2gp1c3), new Gamete(p2gp2c1, p2gp2c2, p2gp2c3));
        System.out.println("P2: " + p2);

        // Meios P1 to create a set of gamates
        List<Gamete> sperm = p1.meios(rnd);

        // Meios P2 to create a set of gamates
        List<Gamete> eggs = p2.meios(rnd);

        // Mate P1 and P2 gamates to create a zygote
        Zygote c = Gamete.mate(sperm, eggs, rnd);
        System.out.println("Child: " + c);
    }
}
