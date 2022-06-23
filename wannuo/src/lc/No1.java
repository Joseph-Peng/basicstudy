package lc;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No1 {

    public boolean strongPasswordCheckerII(String password) {
        if(password == null || password.length() < 8) return false;
        boolean up = false;
        boolean low = false;
        boolean digit = false;
        boolean other = false;

        String otherString = "!@#$%^&*()-+";
        Set<Character> set = new HashSet<>();
        for (char ch : otherString.toCharArray()){
            set.add(ch);
        }

        for(int i = 0; i < password.length(); ++i){
            if(i > 0 && password.charAt(i) == password.charAt(i-1)) return false;
            char ch = password.charAt(i);
            if (set.contains(ch)){
                other = true;
                continue;
            }
            else if (Character.isDigit(ch)) {
                digit = true;
            }
            else if (Character.isLowerCase(ch)) {
                low = true;
            }
            if (Character.isUpperCase(ch)) {
                up = true;
            }
        }
        return up && low && digit && other;
    }
}
