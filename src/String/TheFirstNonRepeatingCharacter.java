package String;

/**
 * Created by lqs on 2018/4/16.
 */
public class TheFirstNonRepeatingCharacter {
    //Insert one char from stringstream
    public int[] hash = new int[256];
    public StringBuffer sb = new StringBuffer();

    public void Insert(char ch) {
        sb.append(ch);
        hash[ch] += 1;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < sb.length(); i++) {
            if(hash[sb.charAt(i)] == 1){
                return sb.charAt(i);
            }
        }
        return '#';
    }
}
