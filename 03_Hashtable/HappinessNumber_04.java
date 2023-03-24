import java.util.HashSet;

public class HappinessNumber_04 {

    public boolean isHappy(int n) {
        HashSet<Integer> appeared = new HashSet<>();
        if (n == 1)
            return true;
        appeared.add(n);
        int temp;
        int sum;
        while (true) {
            sum = 0;
            while (n != 0) {
                temp = n % 10;
                n /= 10;
                sum += temp * temp;
            }
            if (sum == 1) {
                return true;
            } else if (appeared.contains(sum))
                return false;
            else
                appeared.add(sum);
            n = sum;
        }
    }
}
