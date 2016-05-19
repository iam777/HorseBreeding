package genetics;

import com.ryanmichela.horsebreeding.Randomable;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by rmichela on 5/17/16.
 */
public class MockRandom implements Randomable {
    private final Iterator<Integer> ints;
    private final Iterator<Boolean> bools;

    public MockRandom(Stream<Boolean> bools, Stream<Integer> ints) {
        this.bools = bools.iterator();
        this.ints = ints.iterator();
    }

    public int nextInt(int max) {
        int i = ints.next();
        return i > max ? max : i;
    }

    public boolean nextBoolean() {
        return bools.next();
    }

    public static MockRandom allZero() {
        return new MockRandom(Stream.iterate(false, b -> false), Stream.iterate(0, i -> 0));
    }

    public static MockRandom allOne() {
        return new MockRandom(Stream.iterate(true, b -> true), Stream.iterate(1, i -> 1));
    }
}
