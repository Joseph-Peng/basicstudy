package offer;

public class Offer67_把字符串转换成整数 {

    public int strToInt(String str) {
        if (str==null || str.length()==0) return 0;
        StringBuffer sb = new StringBuffer();
        char[] c = str.toCharArray();
        int i = 0;
        int sign = 0;
        while (c[i] == ' ') {
            ++i;
            if (i>= str.length()) return 0;
        }
        if (c[i] == '-') {
            sign = -1;
        }
        if (c[i] == '-' || c[i] == '+') ++i;
        int res = 0, boundary = Integer.MAX_VALUE/10;
        for (;i< c.length;++i){
            int num = c[i]-'0';
            if (num>=0 && num<=9){
                if (res >boundary || (res==boundary && num>7)){
                    return sign==-1? Integer.MIN_VALUE :Integer.MAX_VALUE;
                }
                res = res*10+num;
            }else {
                break;
            }
        }
        return sign == -1? -res:res;
    }
}
