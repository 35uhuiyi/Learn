package alg4.Leetcode.String;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    Map<String, Integer> map = new HashMap<>();
    public WordFrequency(String[] book) {
        for(String s : book){
            int i = map.getOrDefault(s, 0);
            map.put(s, i+=1);
        }
    }
    public int get(String word) {
        int ans = map.get(word);
        return ans;
    }

    public static void main(String[] args) {
        String[] strings = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
        WordFrequency wordFrequency = new WordFrequency(strings);
        int have = wordFrequency.get("have");
        System.out.println(have);

    }
}
