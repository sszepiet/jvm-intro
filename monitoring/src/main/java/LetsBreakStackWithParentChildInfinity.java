import java.util.Objects;

public class LetsBreakStackWithParentChildInfinity {

    public static void main(String[] args) {
        CallsOther one = new CallsOther(1);
        CallsOther two = new CallsOther(2);
        one.setChild(two);
        two.setParent(one);
        System.out.println(one.toString());
    }

    static class CallsOther {
        private final int identifier;
        private CallsOther child;
        private CallsOther parent;

        public CallsOther(int identifier) {
            this.identifier = identifier;
        }

        public void setChild(CallsOther child) {
            this.child = child;
        }

        public void setParent(CallsOther parent) {
            this.parent = parent;
        }

        public String toString() {
            return Objects.toString(this);
        }
    }
}
