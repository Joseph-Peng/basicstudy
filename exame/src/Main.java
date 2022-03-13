import java.util.*;

public class Main {
    static class Node {
        public int color;
        public int nodeIndex;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val, int nodeIndex) {
            color = _val;
            this.nodeIndex=nodeIndex;
        }

        public Node(int _val, Node _left, Node _right) {
            color = _val;
            left = _left;
            right = _right;
        }
    }
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 节点数
        Map<Integer,Node> map = new HashMap<>();
        for (int i = 0;i<n;++i){
            Node node = new Node(sc.nextInt(),i+1);
            map.put(i+1,node);
        }
        Node root = null;
        for (int i = 0;i<n;++i){
            int parent = sc.nextInt();
            if (parent == 0){
                root = map.get(i+1);
            }else {
                Node parentNode = map.get(parent);
                if (parentNode.left!=null){
                    parentNode.right = map.get(i+1);
                }else {
                    parentNode.left = map.get(i+1);
                }
            }
        }

        postOrder(root);
        //System.out.println(3+" "+2);
        System.out.println(res);
    }

    private static void postOrder(Node root) {
        postOrder(root.left);
        postOrder(root.right);
        if (root.color==0){
            if(isGoodNodeWithe(root)) res.add(root.nodeIndex);
        }else {
            if(isGoodNodeBlack(root)) res.add(root.nodeIndex);
        }

    }

    private static boolean isGoodNodeWithe(Node root) {
        if (root.color == 0 && root.left==null && root.right==null) return true;
        Queue<Node> queue = new LinkedList<>();
        if(root!=null) queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size;i++){
                Node node = queue.poll();
                if (node.color == 1) return true;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return false;
    }

    private static boolean isGoodNodeBlack(Node root) {
        if (root.left==null && root.right==null) return true;
        Queue<Node> queue = new LinkedList<>();
        if(root!=null) queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size;i++){
                Node node = queue.poll();
                if (node.color == 1) return false;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return true;
    }
}
