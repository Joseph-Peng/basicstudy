package lc1000to2000;

/**
 * @author Joseph Peng
 * @date 2023/5/6 9:40
 */
public class LC1419_数青蛙 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        // PREVIOUS 记录 croak 中的每个字母的上一个字母，从而避免写出大量 if-else。
        char[] previous = new char[128];
        char chs[] = "croakc".toCharArray();
        for(int i = 1; i < chs.length; ++i){
            previous[chs[i]] = chs[i-1];
        }

        int[] cnt = new int[128];
        for(char ch : croakOfFrogs.toCharArray()){
            char pre = previous[ch];
            if (cnt[pre] > 0){
                cnt[pre]--;
            }else if (ch != 'c'){
                return -1;
            }
            cnt[ch]++;
        }
        if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0)
            return -1; // 有发出其它声音的青蛙，不符合要求
        return cnt['k']; // 最后青蛙们都发出了 'k' 的声音
    }

    // 模拟计数
    public int minNumberOfFrogs1(String croakOfFrogs) {
        if(croakOfFrogs.length() % 5 != 0) return -1;
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int res = 0;
        for(int i = 0; i < croakOfFrogs.length(); ++i){
            char ch = croakOfFrogs.charAt(i);
            if(ch == 'c'){
                if(k > 0){
                    k--;
                }else{
                    res++;
                }
                c++;
            }else if(ch == 'r'){
                c--;
                r++;
            }else if(ch == 'o'){
                r--;
                o++;
            }else if(ch == 'a'){
                o--;
                a++;
            }else if(ch == 'k'){
                a--;
                k++;
            }
            if(c < 0 || r < 0 || o < 0 || a < 0){
                break;
            }
        }
        if(c != 0 || r != 0 || o != 0 || a != 0){
            return -1;
        }
        return res;
    }
}
