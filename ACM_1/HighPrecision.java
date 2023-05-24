import java.io.*;
import java.math.BigDecimal;

public class HighPrecision {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        BigDecimal pre = new BigDecimal(reader.readLine());
        BigDecimal last = new BigDecimal(reader.readLine());
        out.println(pre.add(last));
        reader.close();
        out.close();
    }
}
