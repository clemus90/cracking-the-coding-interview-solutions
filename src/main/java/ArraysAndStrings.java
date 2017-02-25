import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by christian on 23/02/17.
 */
public class ArraysAndStrings {
    /* EXERCISES */
    /* 1.1 Is Unique */
    public boolean isUniqueWithHashTable(String str){
        HashSet<Character> present = new HashSet<Character>();
        boolean isUnique = true;
        for(int i=0; i< str.length(); i++){
            char curChar = str.charAt(i);
            if(present.contains(curChar)){
                isUnique = false;
                break;
            }else{
                present.add(curChar);
            }
        }
        return isUnique;
    }

    public boolean isUnique(String str){
        if (str.length() > 128) return false;
        boolean[] charSet = new boolean[128];
        for(int i=0; i<str.charAt(i); i++) {
            char curr = str.charAt(i);
            if(charSet[curr]) return false;
            else charSet[curr] = true;
        }
        return true;
    }

    /* 1.2  Check Permutation */
    public boolean checkPermutation(String s1, String s2){
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        for(char c: s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c,0) + 1);
        }
        for(char c: s2.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) - 1);
        }
        for(char c: charCount.keySet()){
            if(charCount.get(c) != 0){
                return false;
            }
        }
        return true;
    }

    public boolean checkPermutationClean(String s1, String s2){
        if(s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }

    /* */

    /* HELPERS */
    public String sort(String s){
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
}
