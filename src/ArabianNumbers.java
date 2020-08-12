import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArabianNumbers {
    public static int calculateArabian() throws IOException {
        int out;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        String[] arr = str.split("");

        for (RomanNumbers s: RomanNumbers.values()) {
            if (String.valueOf(s).equals(arr[0]) ||String.valueOf(s).equals(arr[2]))
                throw new NumberFormatException();
        }

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

}
