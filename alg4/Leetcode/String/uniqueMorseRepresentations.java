package alg4.Leetcode.String;

import java.util.ArrayList;
import java.util.List;

/*国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。

        为了方便，所有26个英文字母对应摩尔斯密码表如下：

        [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。

        返回我们可以获得所有词不同单词翻译的数量。

        例如:
        输入: words = ["gin", "zen", "gig", "msg"]
        输出: 2
        解释:
        各单词翻译如下:
        "gin" -> "--...-."
        "zen" -> "--...-."
        "gig" -> "--...--."
        "msg" -> "--...--."

        共有 2 种不同翻译, "--...-." 和 "--...--.".*/
public class uniqueMorseRepresentations {
    public int uniqueMorseRepresentationsf(String[] words) {
        List<String> ansString = new ArrayList<>();
        String[] Morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(int i=0;i<words.length;i++){
            String word = words[i];//每个单词
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];//每个字母
                int b=c-'a';
                stringBuilder.append(Morse[b]) ;
            }
            String string = stringBuilder.toString();
            if(!ansString.contains(string)){
                ansString.add(string);
            }
        }
        return ansString.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        uniqueMorseRepresentations uniqueMorseRepresentations = new uniqueMorseRepresentations();
        int i = uniqueMorseRepresentations.uniqueMorseRepresentationsf(words);
        System.out.println(i);
    }


}
