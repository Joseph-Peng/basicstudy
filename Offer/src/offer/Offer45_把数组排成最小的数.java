package offer;

import java.util.Arrays;
import java.util.Comparator;

public class Offer45_把数组排成最小的数 {

    // QuickSort
    public String minNumber(int[] nums) {
        String strs[] = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuffer res = new StringBuffer();
        for (String s : strs){
            res.append(s);
        }
        return res.toString();
    }
}
