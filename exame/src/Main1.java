import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        for(int i = 0; i <n;++i){
            int digit = sc.nextInt();
            if (digit%11==0 || haveTwoOne(digit)){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }

    private static boolean haveTwoOne(int digit) {
        int sum = 0;
        while (digit!=0){
            int temp = digit%10;
            if (temp == 1) sum++;
            digit/=10;
        }
        return sum>=2;
    }
}
