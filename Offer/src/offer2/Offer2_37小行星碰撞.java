package offer2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Offer2_37小行星碰撞 {

    public static void main(String[] args) {
        int[] asteroids = {4,5,-6,4,8,-5};
        System.out.println(Arrays.toString(new Offer2_37小行星碰撞().asteroidCollision(asteroids)));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(asteroids[0]);
        int i = 1;
        while (i<asteroids.length){
            if(!stack.isEmpty() && stack.peek()>0 && asteroids[i]<0){
                int left = Math.abs(asteroids[i]);
                if(stack.peek() > left){
                    ++i;
                    continue;
                }else if(stack.peek()<left){
                    stack.pop();
                }else {
                    stack.pop();
                    ++i;
                }
            }else {
                stack.push(asteroids[i]);
                ++i;
            }
        }
        int[] res = new int[stack.size()];
        for (i = stack.size()-1; i>=0; --i){
            res[i] = stack.pop();
        }
        return res;
    }

}
