import java.util.*;

public class SolveSudoku_21 {
    // 不要想着怎么样才能更快了，操作变复杂了反而更慢了
    // 老老实实回溯就行了
    // 我是傻逼

    private ArrayList<Character> standard = new ArrayList<Character>() {
        {
            add('1');
            add('2');
            add('3');
            add('4');
            add('5');
            add('6');
            add('7');
            add('8');
            add('9');
        }
    };
    private ArrayList[][] lists = new ArrayList[3][9];
    private char[][] board;
    private boolean flag = false;
    private int[] nums = new int[27];;
    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < lists.length; i++) {
            for (int j = 0; j < lists[i].length; j++) {
                lists[i][j] = new ArrayList<>(standard);
            }
        }
        int num = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.'){
                    num++;
                    continue;
                }
                lists[0][i].remove((Object) c);
                lists[1][j].remove((Object) c);
                lists[2][mapping(i, j)].remove((Object) c);
            }
        }
        for (int i = 0; i < lists.length; i++) {
            for (int j = 0; j < lists[i].length; j++) {
                nums[i * 9 + j] = lists[i][j].size();
            }
        }
        backtracking(num);
    }

    public void backtracking(int num) {
        if (num == 0) {
            flag = true;
            return;
        }
        int min = 30;
        int minIndex = 0;
        for (int i = 0; i < 27; i++) {
            if (nums[i] != 0 && nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        int i = minIndex / 9;
        int j = minIndex % 9;
        if (i == 0) {
            // j表示行
            for (int h = 0; h < 9; h++) {
                if (board[j][h] != '.')
                    continue;
                int index = mapping(j, h);
                ArrayList<Character> chars = findAvailable(j, h, index);
                for (Character c : chars) {
                    lists[0][j].remove((Object) c);
                    lists[1][h].remove((Object) c);
                    lists[2][index].remove((Object) c);
                    nums[j]--;
                    nums[9 + h]--;
                    nums[18 + index]--;
                    board[j][h] = c;
                    backtracking(num - 1);
                    if (flag)
                        return;
                    board[j][h] = '.';
                    nums[j]++;
                    nums[9 + h]++;
                    nums[18 + index]++;
                    lists[0][j].add(c);
                    lists[1][h].add(c);
                    lists[2][index].add(c);
                }
            }
        } else if (i == 1) {
            // j表示列
            for (int h = 0; h < 9; h++) {
                if (board[h][j] != '.')
                    continue;
                int index = mapping(h, j);
                ArrayList<Character> chars = findAvailable(h, j, index);
                for (Character c : chars) {
                    lists[0][h].remove((Object) c);
                    lists[1][j].remove((Object) c);
                    lists[2][index].remove((Object) c);
                    nums[h]--;
                    nums[9 + j]--;
                    nums[18 + index]--;
                    board[h][j] = c;
                    backtracking(num - 1);
                    if (flag)
                        return;
                    board[h][j] = '.';
                    nums[h]++;
                    nums[9 + j]++;
                    nums[18 + index]++;
                    lists[0][h].add(c);
                    lists[1][j].add(c);
                    lists[2][index].add(c);
                }
            }
        } else {
            // j表示第几个九宫格
            int leftI = (j / 3) * 3;
            int leftJ = (j % 3) * 3;
            for (int h = leftI; h < leftI + 3; h++) {
                for (int k = leftJ; k < leftJ + 3; k++) {
                    if (board[h][k] != '.')
                        continue;
                    int index = mapping(h, k);
                    ArrayList<Character> chars = findAvailable(h, k, index);
                    for (Character c : chars) {
                        lists[0][h].remove((Object) c);
                        lists[1][k].remove((Object) c);
                        lists[2][index].remove((Object) c);
                        nums[h]--;
                        nums[9 + k]--;
                        nums[18 + index]--;
                        board[h][k] = c;
                        backtracking(num - 1);
                        if (flag)
                            return;
                        board[h][k] = '.';
                        nums[h]++;
                        nums[9 + k]++;
                        nums[18 + index]++;
                        lists[0][h].add(c);
                        lists[1][k].add(c);
                        lists[2][index].add(c);
                    }
                }
            }
        }

    }

    public ArrayList<Character> findAvailable(int i, int j, int index) {
        ArrayList<Character> chars = new ArrayList<>();
        for (int h = 0; h < lists[0][i].size(); h++) {
            char c = (char) lists[0][i].get(h);
            if (lists[1][j].contains(c) && lists[2][index].contains(c))
                chars.add(c);
        }
        return chars;
    }

    public int mapping(int i, int j) {
        switch (i) {
            case 0:
            case 1:
            case 2:
                if (j <= 2)
                    return 0;
                else if (j >= 6)
                    return 2;
                else
                    return 1;
            case 3:
            case 4:
            case 5:
                if (j <= 2)
                    return 3;
                else if (j >= 6)
                    return 5;
                else
                    return 4;
            case 6:
            case 7:
            case 8:
                if (j <= 2)
                    return 6;
                else if (j >= 6)
                    return 8;
                else
                    return 7;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        SolveSudoku_21 solveSudoku = new SolveSudoku_21();
        solveSudoku.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
