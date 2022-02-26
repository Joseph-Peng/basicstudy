package bytedance;

import java.util.*;

public class 找周期 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i<n; ++i){
            int m = in.nextInt();
            int[] arr = new int[m];
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<m;++j){
                arr[j] = in.nextInt();
                set.add(arr[j]);
            }
            boolean flag = false;
            for(int t = 1; t<arr[m-1] - arr[0];++t){
                int left = 0, right = m-1;
                while (left<right && arr[left]+t<arr[m-1]){
                    if (set.contains(arr[left]+t) && set.contains(arr[right]-t)){
                        System.out.println(t);
                        flag = true;
                        break;
                    }else {
                        if (!set.contains(arr[left]+t)) left++;

                        if (!set.contains(arr[right]-t)) right--;
                    }
                }
                if (flag) break;
            }
        }
    }
}
