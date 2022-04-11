package lc051_100;

public class LC91_解码方法 {

    public int numDecodings(String s) {
        int n = s.length();
        int p = 1, pp = 0, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i-1) != '0') {
                c += p;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0') <= 26) {
                c += pp;
            }
            pp = p;
            p = c;
        }
        return c;
    }
}
