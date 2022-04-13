package lc000to050;

public class LC43_字符串相乘 {

    // 法一 简单竖乘
    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";

        for (int i = num2.length() - 1; i >= 0; --i) {
            int carry = 0;
            int n2 = num2.charAt(i) - '0';
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }

            for (int j = num1.length() - 1; j >= 0; --j) {
                int n1 = num1.charAt(j) - '0';
                int product = n1 * n2 + carry;
                temp.append(product % 10);
                carry = product / 10;
            }
            if (carry != 0) temp.append(carry);
            res = addString(res, temp.reverse().toString());
        }
        return res;
    }

    private String addString(String num1, String num2) {
        int carry = 0;
        StringBuffer res = new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = i < 0 ? 0 : (num1.charAt(i) - '0');
            int n2 = j < 0 ? 0 : (num2.charAt(j) - '0');
            int sum = n1 + n2 + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    // 法2 竖乘优化
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; --i) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; --j) {
                int n2 = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + n1 * n2;
                res[i + j + 1] = sum % 10;
                res[i+j] += sum/10;
            }
        }
        StringBuffer ans = new StringBuffer();
        for(int i = 0; i < res.length;++i){
            if(i==0 && res[i] == 0) continue;
            ans.append(res[i]);
        }
        return ans.toString();
    }

}
