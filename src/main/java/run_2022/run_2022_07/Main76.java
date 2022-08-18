package run_2022.run_2022_07;


/**
 * 错误
 * @author lihaoyu
 * @date 2022/7/16 16:22
 */
public class Main76 {

    public static String minWindow(String s, String t) {
        if(s.length() < t.length() || t.length() == 0 ) return "";
        int left = 0,right = 0, kind = 0, start = 0 , end = 0,tempKind = 0;
        int []source = new int[500];
        int []temp = new int[500];
        for (int i = 0; i < t.length(); i++) {
            if (source[t.charAt(i)] == 0){
                kind++;
            }
            source[t.charAt(i)] += 1;
        }
        while(right < s.length()){
            if(source[s.charAt(right)] == 0 ) { right++; continue;}
            temp[s.charAt(right)]++;
            if (temp[s.charAt(right)] == source[s.charAt(right)]){
                tempKind++;
            }
            if(tempKind == kind){
                end = right;
                break;
            }
            right++;
        }
        if(tempKind != kind) return "";
        // 收
        while(true){
            if(source[s.charAt(left)] == 0 ){
                left++;
                continue;
            }
            if (temp[s.charAt(left)] == source[s.charAt(left)]){
                start = left;
                break;
            }
            if (temp[s.charAt(left)] > source[s.charAt(left)]){
                temp[s.charAt(left)]--;
                left++;
            }
        }
        return s.substring(start,end+1);
    }

    public static void main(String[] args) {
        System.out.println(Main76.minWindow("ADOBECODEBANC", "ABC"));
    }

}
