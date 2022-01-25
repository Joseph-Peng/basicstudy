package offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Offer50_第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new LinkedHashMap<>();
        for(int i = 0; i<s.length(); ++i){
            char ch = s.charAt(i);
            map.put(ch, !map.containsKey(ch));
        }

        for(Map.Entry<Character,Boolean> entry : map.entrySet()){
            if(entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}


