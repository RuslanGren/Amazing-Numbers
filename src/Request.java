import java.util.Arrays;

public class Request {
    public static boolean isContain(String inputStr, String[] items) {
        for (String item : items) {
            if (inputStr.equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }

    public static boolean findOppositeProperties(String[] searchProperties) {
        String[] oppositeProperties = new String[2];
        int k = 0;
        for (String i : searchProperties) {
            for (String j : searchProperties) {
                if (i.equalsIgnoreCase(oppositePair(j))) {
                    oppositeProperties[k++] = i;
                    break;
                }
            }
        }
        if (k == 2) {
            System.out.println("The request contains mutually exclusive properties: " + Arrays.toString(oppositeProperties).toUpperCase());
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        return true;
    }

    private static String oppositePair (String property) {
        if (property.startsWith("-")) {
            return property.replace("-", "");
        }
        return "-" + property;
    }

    public static boolean correctProperties(String[] input) {
        if (isContain("even", input) && isContain("odd", input) || (isContain("-even", input) && isContain("-odd", input))) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        if (isContain("sunny", input) && isContain("square", input) ||  (isContain("-sunny", input) && isContain("-square", input))) {
            System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        if (isContain("duck", input) && isContain("spy", input) || (isContain("-duck", input) && isContain("-spy", input))) {
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        if (isContain("happy", input) && isContain("sad", input) || (isContain("-happy", input) && isContain("-sad", input))) {
            System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        return true;
    }

    public static boolean availableProperties(String[] input) {
        int countError = 0;
        StringBuilder messageError = new StringBuilder();
        for (int i = 2; i < input.length; i++) {
            String temp = input[i];
            if (temp.startsWith("-")) temp = temp.substring(1);
            if (!isContain(temp, Properties.values)) {
                countError++;
                messageError.append(input[i].toUpperCase()).append(", ");
            }
        }
        if (countError == 1) {
            messageError.deleteCharAt(messageError.length() - 1);
            messageError.deleteCharAt(messageError.length() - 1);
            System.out.printf("The property [%s] is wrong.\n", messageError);
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return false;
        } else if (countError > 1) {
            messageError.deleteCharAt(messageError.length() - 1);
            messageError.deleteCharAt(messageError.length() - 1);
            System.out.printf("The properties [%s] are wrong.\n", messageError);
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return false;
        } else {
            return true;
        }
    }
}
