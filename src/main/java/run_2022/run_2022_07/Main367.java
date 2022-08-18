package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/25 22:47
 */
public class Main367 {



    public boolean isPerfectSquare(int num) {
        long n = num;
        if(num == 1) return true;
        long left = 1,right = n,mid,temp;
        while(left <= right){
            mid = (left + right) /2;
            temp = mid * mid;
            if(temp == n) return true;
            if(temp < n) left = mid + 1;
            else right = mid -1;
        }
        return false;
    }

}
