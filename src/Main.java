import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        info();
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a request: ");
            String[] input = scanner.nextLine().split(" ");
            System.out.println();
            if (isNumeric(input[0])) {
                long value = Long.parseLong(input[0]);
                if (value > 0) {
                    if (input.length == 1) {
                        new Properties(value).printOnce();
                    } else {
                        long count = Long.parseLong(input[1]);
                        if (count > 0) {
                            if (input.length == 2) {
                                for (int i = 0; i < count; i++) {
                                    System.out.println(new Properties(value + i).printMany());
                                }
                            } else {
                                if (Request.availableProperties(input)) {
                                    if (Request.correctProperties(input) && Request.findOppositeProperties(input)) {
                                        int total = 0;
                                        for (long i = value; total != count; i++) {
                                            String out = new Properties(i).printMany();
                                            boolean flag = true;
                                            for (int j = 2; j < input.length; j++) {
                                                if (input[j].startsWith("-")) {
                                                    if (out.contains(input[j].substring(1).toLowerCase())) {
                                                        flag = false;
                                                        break;
                                                    }
                                                } else if (!out.contains(input[j].toLowerCase())) {
                                                    flag = false;
                                                    break;
                                                }
                                            }
                                            if (flag) {
                                                System.out.println(out);
                                                total++;
                                            }
                                        }
                                    }
                                }
                            }
                        } else System.out.println("The second parameter should be a natural number.");
                    }
                } else if (value == 0) {
                    System.out.println("Goodbye!");
                    break;
                } else System.out.println("The first parameter should be a natural number or zero.");
            } else System.out.println("The first parameter should be a natural number or zero.");
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void info() {
        System.out.print("""
                Welcome to Amazing Numbers!
                                
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.
                """);
    }

}