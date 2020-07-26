package array;

/**
 * @author lqs
 * @version 1.0
 * @date 2020/7/12 8:46 下午
 */
public class CharacterReplacement {

    public static int characterReplacement(String s, int k) {

        if(s == null || s.length() == 0 ) {
            return 0;
        }

        int res = 0;
        int left = 0;
        int maxCount = 0;
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for(int right = 0 ; right < chars.length ; right++){

            map[chars[right] - 'A']++;
            maxCount = Math.max(maxCount , map[chars[right] - 'A']);
            if(right - left + 1 > maxCount + k ){
                map[chars[left] - 'A']--;
                left++;

            }

            res = Math.max(res , right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int abaa = characterReplacement("ABAA", 0);
    }
}
