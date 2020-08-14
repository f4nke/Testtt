import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    String finalOut;


    public String toString() {
        return finalOut;
    }

    public Calculator() throws IOException {
    }

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    {
        String str = in.readLine();
        String[] arr = str.split("[+-/*]");
        System.out.println(arr[0] + " " + arr[1]);

        try {
            if ((Integer.parseInt(arr[0]) > 0 && Integer.parseInt(arr[0]) <= 10) && (Integer.parseInt(arr[1]) > 0 && Integer.parseInt(arr[1]) <= 10)) {
                finalOut = String.valueOf(ArabianNumbers.calculateArabian(str, arr));
            } else
                finalOut = RomanNumbers.calculateRome(str, arr);
        } catch (NumberFormatException e) {
            finalOut = RomanNumbers.calculateRome(str, arr);
        }

    }


}

