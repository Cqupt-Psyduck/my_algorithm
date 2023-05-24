import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class ABProblem {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        BigInteger pre = new BigInteger(reader.readLine());
        BigInteger last = new BigInteger(reader.readLine());
        out.println(pre.multiply(last));
        reader.close();
        out.close();
    }
}
