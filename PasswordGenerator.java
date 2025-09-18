package password;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIALS = "!@#$%^&*";
    private static final String ALL_CHARS = LOWERCASE + UPPERCASE + NUMBERS + SPECIALS;

    private int length;
    private Random rand;

    public PasswordGenerator(int length) {
        this.length = length;
        this.rand = new Random();
    }

    public String generate() {
        if (length < 8 || length > 12) {
            return "Error: Length must be between 8 and 12!";
        }

        char[] password = new char[length];
        password[0] = LOWERCASE.charAt(rand.nextInt(LOWERCASE.length()));
        password[1] = UPPERCASE.charAt(rand.nextInt(UPPERCASE.length()));
        password[2] = NUMBERS.charAt(rand.nextInt(NUMBERS.length()));
        password[3] = SPECIALS.charAt(rand.nextInt(SPECIALS.length()));

        for (int i = 4; i < length; i++) {
            password[i] = ALL_CHARS.charAt(rand.nextInt(ALL_CHARS.length()));
        }

        for (int i = 0; i < length; i++) {
            int j = rand.nextInt(length);
            char temp = password[i];
            password[i] = password[j];
            password[j] = temp;
        }

        return String.valueOf(password);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password length (8-12): ");
        int length = scanner.nextInt();

        PasswordGenerator generator = new PasswordGenerator(length);
        String password = generator.generate();
        System.out.println("Generated password: " + password);

        scanner.close();
    }
}