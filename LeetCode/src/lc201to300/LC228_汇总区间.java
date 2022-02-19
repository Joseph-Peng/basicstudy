package lc201to300;

import java.util.ArrayList;
import java.util.List;

public class LC228_汇总区间 {

    public List<String> summaryRanges(int[] nums){
        List<String> res = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i<n){
            int low = i;
            ++i;
            while (i<n && nums[i] == nums[i-1] + 1) ++i;
            int high = i-1;
            StringBuffer bf = new StringBuffer();
            bf.append(Integer.toString(nums[low]));
            if (low<high){
                bf.append("->");
                bf.append(Integer.toString(nums[high]));
            }
            res.add(bf.toString());
        }
        return res;
    }
}
