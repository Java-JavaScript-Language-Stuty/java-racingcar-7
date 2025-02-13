package racingcar;

public class MockRandomProvider {
    private final boolean[] randomStack;
    private int index = 0;

    public MockRandomProvider(boolean... randomStack) {
        this.randomStack = randomStack;
    }

    public boolean mockingRandom() {
        if (index <= randomStack.length) {
            return randomStack[index++];
        }
        throw new IllegalStateException();
    }
}
