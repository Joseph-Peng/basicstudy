package lc451to500;

import java.util.Arrays;

public class LC468_验证IP地址 {

    public static void main(String[] args) {
        String test = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(new LC468_验证IP地址().validIPAddress(test));
    }

    public String validIPAddress(String queryIP) {
        if(queryIP.contains(".")){
            return check4(queryIP);
        } else if (queryIP.contains(":")){
            return check6(queryIP);
        }
        return "Neither";
    }

    private String check6(String queryIP) {
        String[] segments = queryIP.split("\\:", 8);
        if (segments.length != 8) return "Neither";
        for(String segment : segments){
            if (segment.length() == 0 || segment.length() > 4 || !isNumber(segment, 16)) return "Neither";
        }
        return "IPv6";
    }

    private String check4(String queryIP) {
        String[] segments = queryIP.split("\\.", 4);
        if (segments.length != 4) return "Neither";
        for(String segment : segments){
            if (segment.length() == 0 || !isNumber(segment, 10)) return "Neither";
            int num = Integer.parseInt(segment);
            if (num>255 || segment.length()>1 && segment.charAt(0) == '0') return "Neither";
        }
        return "IPv4";
    }

    private boolean isNumber(String segment, int radix) {
        try {
            Integer.parseInt(segment,radix);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
