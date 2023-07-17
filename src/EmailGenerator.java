import com.github.javafaker.Faker;

public class EmailGenerator {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String CYAN = "\u001B[36m";

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + faker.internet().domainName();

        System.out.println("\nGenerated email: " + CYAN + email);
    }
}