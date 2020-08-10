import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println(calculateRome());

    }

    public static int calculateArabian() throws IOException {
        int out;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        String[] arr = str.split("");

        if ((Integer.parseInt(arr[0]) > 0 && Integer.parseInt(arr[0]) <= 10) && (Integer.parseInt(arr[2]) > 0 && Integer.parseInt(arr[2]) <= 10)) {
            if (arr[1].equals("+"))
                out = Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
            else if(arr[1].equals("-"))
                out = Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
            else if (arr[1].equals("*"))
                out = Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]);
            else if (arr[1].equals("/"))
                out =  Integer.parseInt(arr[0]) / Integer.parseInt(arr[2]);
            else
                throw new IllegalArgumentException();
        }
        else
            throw new NumberFormatException();
        return out;
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

