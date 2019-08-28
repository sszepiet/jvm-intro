import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class HelloSda {

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Can't run with fewer than 2 arguments");
        }
        System.out.println("Hello " + new User(args[0], args[1]));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class User {
        private final String firstName;
        private final String lastName;
    }
}
