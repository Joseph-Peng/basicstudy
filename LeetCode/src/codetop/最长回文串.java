package codetop;

public class 最长回文串 {

    /*
    给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
    在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
示例 1:

输入:s = "abccccdd"
输出:7
解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int longestPalindrome(String s) {
        int arr[] = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        return count == 0?s.length():(s.length() - count + 1);
    }
}
