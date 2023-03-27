import java.util.HashMap;

public class RansomLetter_07 {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.replace(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }
        char c;
        for (int i = 0; i < ransomNote.length(); i++) {
            c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.replace(c, map.get(c) - 1);
                }
            } else
                return false;
        }
        return true;
    }
}
