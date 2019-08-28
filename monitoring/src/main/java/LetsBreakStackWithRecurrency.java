public class LetsBreakStackWithRecurrency {

    public static void main(String[] args) {
        recurrentCall(10);
    }

    public static void recurrentCall(int i) {
        recurrentCall(i);
    }
}
