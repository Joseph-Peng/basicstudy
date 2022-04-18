package lc151to200;

public class LC165_比较版本号 {

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1","1.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i<arr1.length || j<arr2.length){
            String s1 = i >= arr1.length? "0":arr1[i++];
            String s2 = j >= arr2.length? "0":arr2[j++];
            int n1 = Integer.valueOf(s1);
            int n2 = Integer.valueOf(s2);
            if(n1 == n2) continue;
            else if(n1<n2) return -1;
            else if(n1>n2) return 1;
        }
        return 0;
    }
}
