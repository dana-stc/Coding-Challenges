import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Ex1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        checkRegexValidaity(testCases, in);
    }

    private static void checkRegexValidaity(int testCases, Scanner in) {
        int counter = testCases;

        if (counter < 0) {
            throw new IllegalArgumentException();
        }
        while (counter > 0) {
            String line = in.nextLine();
            try {
                Pattern.compile(line);
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
            counter--;
        }
    }
}
