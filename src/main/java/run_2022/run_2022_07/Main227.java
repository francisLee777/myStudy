package run_2022.run_2022_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lihaoyu
 * @date 2022/7/30 10:25
 */
public class Main227 {

    Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('-',1);
        put('+',1);
        put('*',2);
        put('/',2);
    }};

    void cal(Stack<Integer> number,Stack<Character> op){
        if(number.size() < 2 || op.isEmpty()) return;
        Integer pop1 = number.pop();
        Integer pop2 = number.pop();
        Character pop = op.pop();
        switch (pop){
            case '+': number.push(pop1+pop2); break;
            case '-': number.push(pop2-pop1);break;
            case '*': number.push(pop1*pop2);break;
            case '/': number.push(pop2/pop1);break;
            default:
        }
    }

    public int calculate(String s) {
        // 去除空格
        s = s.replace(" ","");
        if(s.length() == 0 ) return 0;
        Stack<Integer> number = new Stack<>();
        if(s.charAt(0) == '-') number.add(0);
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 是数字
            if(c >= '0' && c <= '9'){
                int j = i+1;
                while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9')j++;
                number.add(Integer.parseInt(s.substring(i,j)));
                i=j-1;
                continue;
            }
            // 操作符了
            if(i > 0 && (s.charAt(i-1) == '(' && c == '-')){
                number.add(0);
            }
            if(c == '('){
                op.push(c);
                continue;
            }
            if(c == ')'){
                while(op.peek() != '(') cal(number,op);
                op.pop();
                continue;
            }
            // + - * /
            while(!op.isEmpty() && op.peek() != '(' && map.get(op.peek()) >= map.get(c)){
                cal(number,op);
            }
            op.push(c);
        }
        while(!op.isEmpty())   cal(number,op);
        return number.pop();
    }


    public static void main(String[] args) {
//        System.out.println(new Main224().calculate("1+1*2*3*(1+1)"));
        System.out.println(new Main227().calculate("   (1+(4+5+2)-3)+(6+8)"));

    }
}
