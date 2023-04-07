public class LemonadeChange_13 {

    public boolean lemonadeChange(int[] bills) {
        int[] remainder = new int[2];
        for (int banknote : bills) {
            switch (banknote) {
                case 5:
                    remainder[0] += 1;
                    break;
                case 10:
                    if (--remainder[0] >= 0)
                        remainder[1]++;
                    else
                        return false;
                    break;
                case 20:
                    if (remainder[0] >= 1 && remainder[1] >= 1) {
                        remainder[0]--;
                        remainder[1]--;
                    } else if (remainder[0] >= 3) {
                        remainder[0] -= 3;
                    } else
                        return false;
            }
        }
        return true;
    }
}
