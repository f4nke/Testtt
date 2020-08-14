import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArabianNumbers {
    public static int calculateArabian(String str, String[] arr) throws IOException {
        int out;

        char oper = str.charAt(arr[0].length());

        switch (oper) {
            case '+':
                out = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
                break;
            case '-':
                out = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
                break;
            case '*':
                out = Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
                break;
            case '/':
                out = Integer.parseInt(arr[0]) / Integer.parseInt(arr[1]);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return out;
    }
}
