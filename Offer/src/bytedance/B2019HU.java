package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B2019HU {

    public void solution() {
        Scanner in = new Scanner(System.in);
        int[] count = new int[9], helpArr = new int[9];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 13; ++i) {
            count[in.nextInt() - 1]++;
        }
        for (int i = 0; i < 9; ++i) {
            // 某一张牌的数量不能大于4
            if (count[i] < 4){
                int num = i +1;
                helpArr = Arrays.copyOf(count, 9);
                // 尝试加入i+1对应的牌
                helpArr[i]++;
                if (canHu(helpArr,14,false)) res.add(num);
            }
        }
        if (res.isEmpty()) System.out.println(0);
        else {
            StringBuffer sbf = new StringBuffer();
            sbf.append(res.get(0));
            for (int i = 1; i < res.size(); i++) {
                sbf.append(" ");
                sbf.append(res.get(i));
            }
            System.out.println(sbf.toString());
        }
    }

    private boolean canHu(int[] helpArr, int total, boolean hasHead) {
        if (total == 0) return true; // 说明所有的牌都能组合，能胡牌
        //先找雀头
        if (!hasHead){
            for (int i = 0; i< 9; ++i){
                if (helpArr[i] >= 2 ){
                    helpArr[i] -= 2;
                    if (canHu(helpArr,total-2, true)) return true;
                    helpArr[i] +=2;
                }
            }
            return false; // 没有找到雀头，或者都不能胡牌
        }else { // 已经确定了雀头的情况
            for (int i = 0; i < 9; ++i){
                //从当前这张牌开始
                if (helpArr[i] > 0){
                    // 找刻子
                    if (helpArr[i] >= 3){
                        helpArr[i] -=3;
                        if (canHu(helpArr,total-3,true)) return true;
                        helpArr[i] +=3;
                    }else if (i + 2 < 9 && helpArr[i + 1] > 0 && helpArr[i + 2] > 0){ //不能找刻子就找顺子
                        helpArr[i]--;
                        helpArr[i + 1]--;
                        helpArr[i + 2]--;
                        if (canHu(helpArr, total-3, true)) return true;
                        helpArr[i]++;
                        helpArr[i + 1]++;
                        helpArr[i + 2]++;
                    }
                }
            }
        }
        //执行完毕，total都不为0，说明不能胡牌
        return false;

    }








































   /* private void sln() {
        Scanner sc = new Scanner(System.in);
        int[] state = new int[9], helpArr = new int[9];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            int num = sc.nextInt();
            state[num - 1]++;
        }
        for (int i = 0; i < 9; i++) {
            if (state[i] < 4) {
                int num = i + 1;
                System.arraycopy(state, 0, helpArr, 0, 9);
                helpArr[i]++;
                if (canHu(helpArr, 14, false)) res.add(num);
            }
        }
        if (res.isEmpty()) System.out.println(0);
        else {
            StringBuffer sbf = new StringBuffer();
            sbf.append(res.get(0));
            for (int i = 1; i < res.size(); i++) {
                sbf.append(" ");
                sbf.append(res.get(i));
            }
            System.out.println(sbf.toString());
        }
    }

    private boolean canHu(int[] arr, int total, boolean hasHead) {
        if (total == 0) return true;
        if (!hasHead) {
            for (int i = 0; i < 9; i++) {
                if (arr[i] >= 2) {
                    arr[i] -= 2;
                    if (canHu(arr, total - 2, true)) return true;
                    arr[i] += 2;
                }
            }
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                if (arr[i] > 0) {
                    if (arr[i] >= 3) {
                        arr[i] -= 3;
                        if (canHu(arr, total - 3, true)) return true;
                        arr[i] += 3;
                    }
                    if (i + 2 < 9 && arr[i + 1] > 0 && arr[i + 2] > 0) {
                        arr[i]--;
                        arr[i + 1]--;
                        arr[i + 2]--;
                        if (canHu(arr, total - 3, true)) return true;
                        arr[i]++;
                        arr[i + 1]++;
                        arr[i + 2]++;
                    }
                }
            }
        }
        return false;
    }*/

}



