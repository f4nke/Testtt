import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArabianNumbers {
    public static int calculateArabian(String[] arr) throws IOException {
        int out;


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


        return out;
    }

}
