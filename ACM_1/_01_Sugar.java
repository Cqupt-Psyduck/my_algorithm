import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class _01_Sugar {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            while (T--> 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                int map1[] = new int[n+1];
                int id[] = new int[n+1];
                int have[] = new int[n+1];
                for (int i = 0; i < n; i++) {
                    int name = in.nextInt();
                    int s = in.nextInt();
                    id[i+1]=name;
                    have[i+1] = s;
                }
                for (int i = 0; i < m; i++) {
                    int s = in.nextInt();
                    map1[s]++;
                }
                for (int i = n-1; i >=1; i--) {
                    map1[i] = map1[i]+map1[i+1];
                }
                for (int i=1;i<=n; i++){
                    have[i] = have[i]+map1[i];
                }
                int max0 = 0;
                int max1 = 0;
                int sum = 0;
                for (int i=n; i >= 1; i--){
                    if (id[i]==0){
                        max0 = Math.max(max0, have[i]);
                        if (have[i]<max1){
                            sum++;
                        }
                    }
                    else {
                        max1 = Math.max(max1,have[i]);
                        if (have[i]<max0){
                            sum++;
                        }
                    }
                }
                System.out.println(n-sum);
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        boolean hasNext()
        {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e)
                {
                    return false;
                    // TODO: handle exception
                }
            }
            return true;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public String nextLine()
        {
            String str = null;
            try
            {
                str = reader.readLine();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public BigInteger nextBigInteger()
        {
            return new BigInteger(next());
        }
        public BigDecimal nextBigDecimal()
        {
            return new BigDecimal(next());
        }

    }

    // 可能是因为发功时间不是按序输入使得无法测试通过
    // 改成排序后超时
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group = scanner.nextInt();
        while (group-- > 0) {
            int sugarNum = scanner.nextInt();
            int powerNum = scanner.nextInt();
            List<int[]> sugarQueue = new LinkedList<>();
            for (int i = 0; i < sugarNum; i++) {
                int[] one = new int[2];
                one[0] = scanner.nextInt();
                one[1] = scanner.nextInt();
                sugarQueue.add(one);
            }
            int i = 0;
            int index = 0;
            int[] power = new int[powerNum];
            for (int j = 0; j < powerNum; j++)
                power[j] = scanner.nextInt();
            Arrays.sort(power);
            for (int h = 0; h < powerNum; h++) {
                int powerTime = power[h];
                // 消灭前面的糖糖
                while (i < powerTime) {
                    int[] cur = sugarQueue.get(index);
                    for (int j = 0; j < index; j++){
                        int[] one = sugarQueue.get(j);
                        if (one[0] != cur[0] && one[1] < cur[1]) {
                            sugarQueue.remove(j);
                            j--;
                            index--;
                        }
                    }
                    i++;
                    index++;
                }
                // 发功
                for (int j = 0; j < index; j++) {
                    sugarQueue.get(j)[1] += 1;
                }
            }
            System.out.println(sugarQueue.size());
        }
    }
}
