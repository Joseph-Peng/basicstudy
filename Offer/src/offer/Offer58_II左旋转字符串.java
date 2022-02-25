package offer;

public class Offer58_II左旋转字符串 {

    // abcdefg
    // bacdefg
    // bagfedc
    // cedfgab
    public String reverseLeftWords(String s, int n) {
        char[] charArr = s.toCharArray();
        reverse(charArr, 0, n-1);
        reverse(charArr, n, s.length()-1);
        reverse(charArr, 0, s.length()-1);
        return String.valueOf(charArr);
    }

    public void reverse(char[] c, int low, int high){
        while (low < high){
            char temp = c[low];
            c[low] = c[high];
            c[high] = temp;
            ++low;
            --high;
        }
    }

    public String reverseLeftWords1(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }

    public String reverseLeftWords2(String s, int n) {
        StringBuffer res = new StringBuffer();
        for(int i = n; i<s.length()+n; ++i){
            res.append(s.charAt(i%s.length()));
        }
        return res.toString();
    }

}
