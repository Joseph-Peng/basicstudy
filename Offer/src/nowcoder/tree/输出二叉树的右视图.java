package nowcoder.tree;

import java.util.HashMap;

public class 输出二叉树的右视图 {

    private HashMap<Integer, Integer> ans = new HashMap<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int j = 0;
    public int[] solve (int[] xianxu, int[] zhongxu) {
        //将xianxu节点的值映射到相应的中序节点的下标。
        for(int i = 0; i < zhongxu.length; i++){
            map.put(zhongxu[i], i);
        }
        //开始构建二叉树。
        build(xianxu, zhongxu, 0, xianxu.length-1, 0);

        //创建放回答案的数组
        int[] temp = new int[ans.size()];

        //将值传入数组。
        for(int i = 0; i < ans.size(); i++){
            temp[i] = ans.get(i);
        }

        return temp;
    }

    public void build(int[] xianxu, int[] zhongxu, int left, int right, int i){
        if(left > right){
            return;
        }
        int index = map.get(xianxu[j++]);
        //构建左子树
        build(xianxu, zhongxu, left, index-1, i+1);
        //构建右子树
        build(xianxu, zhongxu, index+1, right, i+1);
        //存储第i层的最右边的那个节点。
        ans.put(i, zhongxu[index]);
    }


}
