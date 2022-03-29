package lc301to350;

public class LC331_验证二叉树的前序序列化 {

    // 无向图和二叉树中，所有节点的入度之和等于出度之和
    // 叶子节点消耗1个入度，0个出度
    // 非叶子节点提供2个出度和消耗1个入度
    public boolean isValidSerialization(String preorder) {
        if (preorder == null) return false;
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes){
            diff -= 1; // 消耗一个入度
            if (diff<0) return false;
            if (!node.equals("#")){
                diff+=2;
            }
        }
        return diff==0;
    }

}
