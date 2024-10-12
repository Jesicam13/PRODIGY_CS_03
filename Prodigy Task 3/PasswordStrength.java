import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        
        String strength = checkPasswordStrength(password);
        System.out.println("Password Strength: " + strength);
    }

    public static String checkPasswordStrength(String password) {
        int score = 0;

       
        if (password.length() >= 8) {
            score++;
        }

        if (Pattern.compile("[A-Z]").matcher(password).find()) {
            score++;
        }

     
        if (Pattern.compile("[a-z]").matcher(password).find()) {
            score++;
        }

       
        if (Pattern.compile("[0-9]").matcher(password).find()) {
            score++;
        }

       
        if (Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) {
            score++;
        }

        switch (score) {
            case 5:
                return "Very Strong";
            case 4:
                return "Strong";
            case 3:
                return "Moderate";
            case 2:
                return "Weak";
            case 1:
            case 0:
                return "Very Weak";
            default:
                return "Unknown";
        }
    }
}
