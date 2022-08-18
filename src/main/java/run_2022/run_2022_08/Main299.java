package run_2022.run_2022_08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2022/8/14 23:22
 */
public class Main299 {


    public static String getHint(String secret, String guess) {
    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();
        Map<Character,Integer> map= new HashMap<>();
    int a=0 , b=0;
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)){
                a++;
            }else{
                s1.append(secret.charAt(i));
                s2.append(guess.charAt(i));
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            int temp = map.getOrDefault(s2.charAt(i),0);
            if(temp != 0){
                b++;
                map.put(s2.charAt(i),temp-1);
            }
        }
return a +"A"+ b +"B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
    }

}
