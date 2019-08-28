import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalPlayground {

    public static void main(String[] args) {
        final User firstUser = new User("Bruce", "Jenner", new Sex(Gender.MALE));
        final User secondUser = new User("Bruce", "Jenner", new Sex(Gender.MALE));
        if (firstUser.equals(secondUser)) {
            System.out.println("Those are equal");
        }
        List<User> users = new ArrayList<>();
        users.add(new User("Bruce", "Jenner", new Sex(Gender.MALE)));
        users.add(new User("Kaitlin", "Jenner", new Sex(Gender.FEMALE)));
        users.add(new User("Bruce", "Jenner", new Sex(Gender.MALE)));
        final Optional<User> maybeUser = users.stream()
                .filter(user -> user.getSex().getGender() == Gender.MALE)
                .findFirst()
                .map(user -> new User("Kaitlin", "Jenner", user.getSex().changeSex()));
        Stream.of("String")
                .forEach(String::toString); // same as string -> string.toString()
        if (maybeUser.isPresent()) { // user != null

        } else {

        }
        /*.forEach(user -> System.out.println(user.toString()));*/
/*        .map(new Function<User, User>() {
            @Override
            public User apply(User user) {
                return new User("Kaitlin", "Jenner", user.getSex().changeSex());
            }
        });*/
    }

    private static class User {
        private final String firstName;
        private final String lastName;
        private final Sex sex;

        public User(String firstName, String lastName, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Sex getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", sex=" + sex +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(firstName, user.firstName) &&
                    Objects.equals(lastName, user.lastName) &&
                    Objects.equals(sex, user.sex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, sex);
        }
    }

    private static class Sex {
        private Gender gender;

        public Sex(Gender gender) {
            this.gender = gender;
        }

        public Gender getGender() {
            return gender;
        }

        public Sex changeSex() {
            switch (gender) {
                case MALE:
                    return new Sex(Gender.FEMALE);
                case FEMALE:
                    return new Sex(Gender.MALE);
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Sex sex = (Sex) o;
            return gender == sex.gender;
        }

        @Override
        public int hashCode() {
            return Objects.hash(gender);
        }
    }

    private enum Gender {
        MALE,
        FEMALE
    }
}
