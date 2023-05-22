import java.io.*;
import java.util.Scanner;

public class ToyPuzzle {
    static StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        sc.nextToken();
        int n = (int) sc.nval;
        sc.nextToken();
        int m = (int) sc.nval;
        boolean[] orientation = new boolean[n];
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            sc.nextToken();
            orientation[i] = sc.nval == 0;
            sc.nextToken();
            name[i] = sc.sval;
        }
        int toy = 0;
        for (int i = 0; i < m; i++) {
            sc.nextToken();
            boolean flag = sc.nval == 0;
            sc.nextToken();
            int gap = (int) sc.nval;
            if (flag == orientation[toy])
                toy = (toy + n - gap) % n;
            else
                toy = (toy + gap) % n;
        }
        System.out.println(name[toy]);
    }
}
