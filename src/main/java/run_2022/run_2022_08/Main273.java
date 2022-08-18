package run_2022.run_2022_08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2022/8/14 23:40
 */
public class Main273 {

Map<Integer, String> map = new HashMap<Integer, String>(){
    {
        put(1,"One");
        put(2,"Two");
        put(3,"Three");
        put(4,"Four");
        put(5,"Five");
        put(6,"Six");
        put(7,"Seven");
        put(8,"Eight");
        put(9,"Nine");
        put(10,"Ten");
        put(11,"Eleven");
        put(12,"Twelve");
        put(13,"Thirteen");
        put(14,"Fourteen");
        put(15,"Fifteen");
        put(16,"Sixteen");
        put(17,"Seventeen");
        put(18,"Eighteen");
        put(19,"Nineteen");
        put(20,"Twenty");
        put(30,"Thirty");
        put(40,"Forty");
        put(50,"Fifty");
        put(60,"Sixty");
        put(70,"Seventy");
        put(80,"Eighty");
        put(90,"Ninety");
    }
};

    public String numberToWords(int num) {
return "";
    }


    String fun(String str){
        String A = "",B="",C="";
        if(str.length() == 3){
            int h = Integer.parseInt(str.substring(0,1));
            if (h != 0){
                A =  map.get(h)+" Hundred";
            }
        }
        boolean small20 = false;
        if(str.length() >= 2){

        }
        if(str.length() == 1){
            int b = Integer.parseInt(str.substring(0,1));
            if(b != 0){
                B = map.get(b);
            }
        }


        return "";
    }

}
