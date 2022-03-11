package offer;

public class Offer58_翻转单词顺序 {

    public String reverseWords(String s) {
        //left从后向前移动
        int left = s.length() - 1, right = s.length() - 1;
        //存放结果
        StringBuffer res = new StringBuffer();

        while (left >= 0){
            //去除多余的空格，找到第一个不为空格的字符
            while (left >= 0 && s.charAt(left) == ' '){
                left--;
            }
            //此时，第一个不为空格的字符，就是这个单词的右边界
            right = left;
            //如果右边界小于0了，也就是没有找到下一个右边界，就直接结束了。
            //比如处理 “   hello  ” 这种字符串，当反转完hello之后，left在找下一个右边界的时候，会直接移动到-1，此时找不到下一个单词的右边界了。
            if (right < 0) break;

            //找到右边界了，接下来找左边界，从后向前找到下一个空格
            while (left >= 0 && s.charAt(left) != ' '){
                left--;
            }
            //此时s.substring(left + 1, right + 1)中间就是一个完整的单词。
            res.append(s.substring(left + 1, right + 1));
            //一个单词之后添加一个空格
            res.append(' ');
        }
        //删除最后的空格，然后返回
        if(res.length()==0) return "";
        return res.deleteCharAt(res.length() - 1).toString();
    }
}
