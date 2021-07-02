package alg4.Leetcode.String;

import java.util.HashMap;
import java.util.Map;

public class countCharacters {
    public int fun(String[] words, String chars){
        Map<Character, Integer> charscnt = new HashMap<>();
        for(int i=0;i<chars.length();i++){
            charscnt.put(chars.charAt(i),(charscnt.getOrDefault(chars.charAt(i), 0)+1));
        }
        int ans=0;
        for (String word : words) {
            Map<Character, Integer> wordcnt = new HashMap<>();
            for(int i=0;i<word.length();i++){
                wordcnt.put(word.charAt(i),(wordcnt.getOrDefault(word.charAt(i),0)+1));
            }
            boolean isans = true;
            for(int i=0;i<word.length();i++){
                if(charscnt.getOrDefault(word.charAt(i),0)<wordcnt.getOrDefault(word.charAt(i),0)){
                    isans = false;
                    break;
                }
            }
            if(isans){
                ans += word.length();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String chars ="atach";
        String[] words = {"cat","bt","hat","tree"};
        countCharacters countCharacters = new countCharacters();
        int fun = countCharacters.fun(words, chars);
        System.out.println(fun);
    }
}
