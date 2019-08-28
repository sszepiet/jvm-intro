package gc;

public class GcExercises {

    public static void main(String [] args) throws InterruptedException {
        ToBeGarbageCollected one = new ToBeGarbageCollected(1);
        ToBeGarbageCollected two = new ToBeGarbageCollected(2);

        one.setOther(two);
        two.setOther(one);

        one = null;
        two = null;

        System.gc();
        Thread.sleep(500L);
    }

    static class ToBeGarbageCollected {

        private final int identifier;
        private ToBeGarbageCollected other;

        public ToBeGarbageCollected(int identifier) {
            this.identifier = identifier;
        }

        public void setOther(ToBeGarbageCollected other) {
            this.other = other;
        }

        @Override
        public void finalize() {
            System.out.println("Garbage collected: " + identifier);
        }
    }
}
