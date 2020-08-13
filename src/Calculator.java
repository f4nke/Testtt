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
        String[] arr = str.split("");

        try {
            if ((Integer.parseInt(arr[0]) > 0 && Integer.parseInt(arr[0]) <= 10) && (Integer.parseInt(arr[2]) > 0 && Integer.parseInt(arr[2]) <= 10)) {
                finalOut = String.valueOf(ArabianNumbers.calculateArabian(arr));
            } else
                finalOut = RomanNumbers.calculateRome(arr);
        } catch (NumberFormatException e) {
            finalOut = RomanNumbers.calculateRome(arr);
        }

    }


}

