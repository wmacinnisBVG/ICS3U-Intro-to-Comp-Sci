package week7;

public class Recursion {
    public static void main(String[] args) {
        int x = factorial(7);
        System.out.println(x);
        int y = factorial2(7);
        System.out.println(y);
        int z = mystery4(3052);
        System.out.println(z);
    }
    public static int mystery4(int n){
        if (n <0){
            return mystery4(-n);
        } else if (n<10){
            return n;
        } else {
            return n %10+mystery4(n/10);
        }
    }

    private static int factorial2(int n) {
        int result = 1;
        for(int i=1; i <= n; i++){
            result *= i;
        }
        return result;
    }

    private static int factorial(int n) {
        if(n == 1 || n == 0){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}
