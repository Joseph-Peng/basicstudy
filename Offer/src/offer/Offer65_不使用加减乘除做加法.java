package offer;

public class Offer65_不使用加减乘除做加法 {

    public int add(int a, int b) {
        // c = a&b是无进位和, c<<1位就表示进位
        // c^(a^b)就是进位和无进位的和
        while (b != 0) {  // 当进位为0时跳出循环
            int c = (a & b) << 1;
            a ^= b; // 无进位和
            b = c; // 使用b来存放进位
        }
        return a;
    }
}
