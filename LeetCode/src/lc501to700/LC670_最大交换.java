package lc501to700;

/**
 * @author Joseph Peng
 * @date 2022/9/13 9:38
 */
public class LC670_最大交换 {

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));
        System.out.println(maximumSwap(1993));
        System.out.println(maximumSwap(98368));
    }

    // 贪心
    public static int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n  = arr.length;
        int maxIdx = n-1;
        int idx1 = -1, idx2 = -1;
        for(int i = n-1; i >= 0; --i){
            if (arr[i] > arr[maxIdx]){
                maxIdx = i;
            }else if(arr[i] < arr[maxIdx]){
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        if (idx1 >= 0){
            swap(arr, idx1, idx2);
        }
        return Integer.parseInt(new String(arr));
    }

    public static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static int maximumSwap1(int num) {
        // 9 9 2 7 3
        /**
         9
         9   max = 9 1
         2   max = 7, 记录2
         找到7跟2交换就完成了
         */
        StringBuffer sb = new StringBuffer(num+"");
        int[] arr = new int[10];
        for(int i = 0; i < sb.length(); ++i){
            int n = sb.charAt(i) - '0';
            arr[n]++;
        }
        int max = 9;
        int idx = 0;
        while(max >= 0 && arr[max] == 0) max--;
        for(int i = 0; i < sb.length(); ++i){
            int n = sb.charAt(i) - '0';
            if(max == n){
                arr[max]--;
                while(max >= 0 && arr[max] == 0) max--;
            }else{
                idx = i;
                break;
            }
        }

        if(max <= 0) return Integer.parseInt(sb.toString());

        for(int i = idx + 1; i < sb.length(); ++i){
            int n = sb.charAt(i) - '0';
            if(n == max && arr[max]-- == 1){
                char ch = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(idx));
                sb.setCharAt(idx, ch);
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
