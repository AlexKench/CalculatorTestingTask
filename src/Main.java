import java.util.Scanner;

public class Main {
    static final String[] ROMAN = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static void main(String[] args) {
        System.out.print("Введите математическое числовое выражение вида (1 + 1), (I - I)," +
                " Арабскими или Римскими цифрами от 1 до 10 со знаком '+, -, *, /' :  ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (calc(s).equals("0")) {
            System.out.println(calc_Rom(s));
        } else {
            System.out.println(calc(s));
        }
    }

    public static String calc(String input) {
        try {
            String[] arrayExpression = input.split(" ");
            if (arrayExpression.length > 3) {
                return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
            }
            try {
                String varOne = arrayExpression[0];
                String operation = arrayExpression[1];
                String varTwo = arrayExpression[2];
                int ans = answer(convertNum(varOne), convertNum(varTwo), operation);
                if (ans == 404) {
                    return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
                }
                return Integer.toString(ans);


            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
            System.exit(0);
            return null;


        } catch (IllegalArgumentException e) {
            return "0";
        }

    }

    static String calc_Rom(String input) {
        try {
            String[] arrayExpression = input.split(" ");
            String varOne = arrayExpression[0];
            String operation = arrayExpression[1];
            String varTwo = arrayExpression[2];
            String[] string = convertRomToNum(varOne, varTwo);
            int ans = answer(convertNum(string[0]), convertNum(string[1]), operation);
            if (ans <= 0) {
                return "throws Exception //т.к. в римской системе нет отрицательных чисел";
            } else if (ans == 404) {
                return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
            }
            return convert((ans));

        } catch (NumberFormatException e) {
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        return "0";
    }

    static int answer(int one, int two, String operator) {
        if (operator.equals("+")) {
            return one + two;
        } else if (operator.equals("-")) {
            return one - two;
        } else if (operator.equals("*")) {
            return one * two;
        } else if (operator.equals("/")) {
            return one / two;
        } else {
            return 404;
        }
    }


    private static String convert(int num) {
        return ROMAN[num];
    }


    static String[] convertRomToNum(String one, String two) {
        try {
            String arrInt = "";
            int oneNumberRome = RomNumber.valueOf(one).getAssociations();
            int twoNumberRome = RomNumber.valueOf(two).getAssociations();
            arrInt += oneNumberRome;
            arrInt += " ";
            arrInt += twoNumberRome;
            return arrInt.split(" ");

        } catch (IllegalArgumentException e) {
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            System.exit(0);
        }
        return null;

    }

    static int convertNum(String num) {
        return Integer.parseInt(num);
    }


}
