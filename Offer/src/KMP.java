public class KMP {


    public static int pattern(String s, String p){
        int[] next = getNext(p);
        int i = 0, j = 0;
        while (i<s.length() && j<p.length()){
            if (j==-1 || s.charAt(i) == s.charAt(j)){
                ++i;
                ++j;
            }else {
                j = next[j];
            }
        }

        return j==p.length()? i-j:-1;
    }

    public static int[] getNext(String ps){
        //char[] p = ps.toCharArray();
        int[] next = new int[ps.length()];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < ps.length()-1){
            if(k==-1 || ps.charAt(j) == ps.charAt(k)){
                next[++j] = ++k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
}
