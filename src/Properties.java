public class Properties {
    private final boolean even;
    private final boolean odd;
    private final boolean buzz;
    private final boolean duck;
    private final boolean palindromic;
    private final boolean gapful;
    private final boolean spy;
    private final boolean square;
    private final boolean sunny;
    private final boolean jumping;
    private final boolean happy;
    private final boolean sad;
    private final String str;
    private final long input;
    public static String[] values = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "square", "sunny", "jumping", "happy", "sad"};

    public Properties(long input) {
        this.input = input;
        this.str = Long.toString(input);
        this.even = isEven();
        this.odd = isOdd();
        this.buzz = isBuzz();
        this.duck = isDuck();
        this.palindromic = isPalindromic();
        this.gapful = isGapful();
        this.spy = isSpy();
        this.square = isSquare();
        this.sunny = isSunny();
        this.jumping = isJumping();
        this.happy = isHappy();
        this.sad = isSad();
    }

    private boolean isEven() {
        return input % 2 == 0;
    }

    private boolean isOdd() {
        return input % 2 == 1;
    }

    private boolean isBuzz() {
        return input % 7 == 0 || input % 10 == 7;
    }

    private boolean isDuck() {
        return !str.startsWith("0") && str.contains("0");
    }

    private boolean isPalindromic() {
        StringBuilder strBuilder = new StringBuilder(str).reverse();
        return strBuilder.toString().equals(str);
    }

    private boolean isGapful() {
        if (str.length() > 2) {
            return input % Integer.parseInt(str.charAt(0) + "" + str.charAt(str.length() - 1)) == 0;
        }
        return false;
    }

    private boolean isSpy() {
        int total = 0;
        int multiply = 1;
        for (char i : str.toCharArray()) {
            total += Character.getNumericValue(i);
            multiply *= Character.getNumericValue(i);
        }
        return total == multiply;
    }

    private boolean isSquare() {
        return Math.sqrt(input) % 1 == 0.0;
    }

    private boolean isSunny() {
        return Math.sqrt(input + 1) % 1 == 0.0;
    }

    public boolean isJumping() {
        if (str.length() == 1) return true;
        for (int i = 1; i < str.length(); i++) {
            if (Math.abs(str.charAt(i) - str.charAt(i - 1)) != 1) {
                return false;
            }
        }
        return true;
    }

    private long happyNumber(long num) {
        long rem, sum = 0;
        while (num > 0) {
            rem = num % 10;
            sum = sum + (rem * rem);
            num = num / 10;
        }
        return sum;
    }

    private boolean isHappy() {
        long result = input;
        while (result != 1 && result != 4) {
            result = happyNumber(result);
        }
        return result == 1;
    }

    private boolean isSad() {
        return !happy;
    }


    public void printOnce() {
        System.out.println("Properties of " + input);
        System.out.println("even: " + even);
        System.out.println("odd: " + odd);
        System.out.println("buzz: " + buzz);
        System.out.println("duck: " + duck);
        System.out.println("palindromic: " + palindromic);
        System.out.println("gapful: " + gapful);
        System.out.println("spy: " + spy);
        System.out.println("sunny: " + sunny);
        System.out.println("square: " + square);
        System.out.println("jumping: " + jumping);
        System.out.println("sad: " + sad);
        System.out.println("happy: " + happy);
    }

    public String printMany() {
        StringBuilder result = new StringBuilder(input + " is");
        if (even) result.append(" even,");
        if (odd) result.append(" odd,");
        if (buzz) result.append(" buzz,");
        if (duck) result.append(" duck,");
        if (palindromic) result.append(" palindromic,");
        if (gapful) result.append(" gapful,");
        if (spy) result.append(" spy,");
        if (square) result.append(" square,");
        if (sunny) result.append(" sunny,");
        if (jumping) result.append(" jumping,");
        if (sad) result.append(" sad,");
        if (happy) result.append(" happy,");
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

}