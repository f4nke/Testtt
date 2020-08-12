import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumbers {

    I(1), II(2), III(3), IV(4), V(5), VI(6),
    VII(7), VIII(8), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private int value;

    RomanNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumbers> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumbers e) -> e.value).reversed())
                .collect(Collectors.toList());
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomanNumbers> romanNumerals = RomanNumbers.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumbers symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumbers> romanNumerals = RomanNumbers.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumbers currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
    public static String calculateRome() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        String[] arr = str.split("");

        int value1 = RomanNumbers.romanToArabic(arr[0]);
        System.out.println("v1 = " + value1);
        int value2 = RomanNumbers.romanToArabic(arr[2]);
        System.out.println("v2 = " + value2);
        int out;

        for (RomanNumbers s: RomanNumbers.values()) {
            if (String.valueOf(s).equals(arr[0]) && !String.valueOf(s).equals(arr[2]))
                throw new NumberFormatException();
        }

        if ((value1 > 0 && value1 <= 10) && (value2 > 0 && value2 <= 10)) {
            if (arr[1].equals("+"))
                out = value1 + value2;
            else if (arr[1].equals("-"))
                out = value1- value2;
            else if (arr[1].equals("*"))
                out = value1 * value2;
            else if (arr[1].equals("/"))
                out =  value1 / value2;
            else
                throw new IllegalArgumentException();
        }
        else
            throw new NumberFormatException();
        System.out.println(out);
        return RomanNumbers.arabicToRoman(out);
    }
}
