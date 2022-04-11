package huawei;

import java.util.*;

public class Main {

    public static List<ArrayList<Integer>> rely = new ArrayList<>();
    public static ArrayList<Integer> res = new ArrayList<>();
    public static int target;
    public static Map<Integer,Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        target = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<n;++i){
            String s = sc.nextLine();
            String ss[] = s.split(",");
            ArrayList<Integer> list = new ArrayList<>();
            if (ss[0].equals("0")) {
                rely.add(list);
                continue;
            }
            for(int j = 1 ; j < ss.length; j++){
                list.add(Integer.valueOf(ss[j]));
            }
            rely.add(list);
        }
        if (rely.get(target).size() == 0) {
            System.out.println("null");
            return;
        }
        ArrayList<Integer> list = rely.get(target);
        for(int sid : list){
            if (rely.get(sid).size() == 0){
                map.put(sid,true);
                res.add(sid);

            }
        }
    }
  
}
