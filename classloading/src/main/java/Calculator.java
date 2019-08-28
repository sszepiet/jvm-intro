public class Calculator {
    public static void main(String[] args) {
        Integer left = 124;
        System.out.println("Left pre method: " + left);
        // left is not incremented after the method because Integer is immutable
        myNewExcellentMethod(left);
        final MyOwnClass aClass = new MyOwnClass(124);
        System.out.println("Custom class pre method: " + aClass.getCounter());
        myNewExcellentMethod(aClass);
        System.out.println("Left after method: " + left);
        System.out.println("Custom class after method: " + aClass.getCounter());
    }

    private static void myNewExcellentMethod(int left) {
        left = left + 1;
        System.out.println("Left after incrementing: " + left);
    }

    private static void myNewExcellentMethod(MyOwnClass instance) {
        instance.setCounter(instance.getCounter() + 1);
        System.out.println("Left after incrementing: " + instance.getCounter());
    }

    static class MyOwnClass {
        private int counter;

        public MyOwnClass(int counter) {
            this.counter = counter;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }
    }
}

