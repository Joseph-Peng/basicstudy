package shence;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Joseph Peng
 * @date 2022/8/13 9:54
 */
public class No3 {

    public static void main(String[] args) {
        String str = "faxxxxfailed";
        int start = str.length() - "failed".length();
        int end = str.length();
        System.out.println(str.substring(start, end));
        TreeMap<Character, Integer> map = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return 0;
            }
        });
        map.put('a',0);
        map.put('c',1);
        map.put('b',0);
        map.put('d',2);
        System.out.println(map.firstKey());
    }
}
