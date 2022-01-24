package lc000to050;

import java.util.*;

public class LC17_电话号码的字母组合 {

    public static void main(String[] args) {
        LC17_电话号码的字母组合 test = new LC17_电话号码的字母组合();
        System.out.println(test.letterCombinations("23"));
    }

    Map<Character, String> dict = new HashMap<Character, String>(){
        {
            put('2',"abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits==null || digits.length()==0) return res;
        backTrace(digits,res,0, new StringBuffer());
        return res;
    }

    private void backTrace(String digits, List<String> res, int i, StringBuffer combination) {
        //System.out.println(i);
        if(i == digits.length()){
            res.add(combination.toString());
            return;
        }

        char digit = digits.charAt(i);
        String letters = dict.get(digit);
        for(int index = 0; index<letters.length(); ++index){
            combination.append(letters.charAt(index));
            backTrace(digits,res,i+1,combination);
            combination.deleteCharAt(combination.length()-1);
        }

    }
}
