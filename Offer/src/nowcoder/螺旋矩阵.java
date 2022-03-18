package nowcoder;

import java.util.ArrayList;

public class 螺旋矩阵 {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (true){
            // 左->右
            for(int i = l; i <= r; ++i) list.add(matrix[t][i]);
            if (++t > b) break;
            // 上->下
            for(int i = t; i <= b; ++i) list.add(matrix[i][r]);
            if (--r<l) break;
            // 右->左
            for(int i = r; i >= l; --i) list.add(matrix[b][i]);
            if (--b<t) break;
            // 下->上
            for(int i = b; i >= t; --i) list.add(matrix[i][l]);
            if (++l>r) break;
        }
        return list;
    }
}
