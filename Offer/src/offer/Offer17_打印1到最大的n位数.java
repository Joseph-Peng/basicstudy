package offer;

public class Offer17_打印1到最大的n位数 {
    int res[];
    int count = 0;
    char[] loop = {'0','1','2','3','4','5','6','7','8','9'};
    public int[] printNumbers(int n) {
        res = new int[(int) Math.pow(10,n)-1];// 没有0
        char[] num = new char[n];
        dfs(num,0);
        return res;
    }

    private void dfs(char[] num, int x) {
        if (x == num.length){
            String temp = new String(num);
            int index = 0;
            while (index<temp.length()-1 && temp.charAt(index) =='0') ++index;
            temp = temp.substring(index);
            if (!temp.equals("0")) res[count++] = Integer.parseInt(temp);
            return;
        }

        for (char d : loop){
            num[x] = d;
            dfs(num,x+1);
        }

    }
}
