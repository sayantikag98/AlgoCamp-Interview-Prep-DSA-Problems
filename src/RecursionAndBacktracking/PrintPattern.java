package RecursionAndBacktracking;

public class PrintPattern {
    public static void main(String[] args) {
        print(0, 0, 10);
    }

    private static void print(int i, int j, int n){
        if(i == n) return;
        if(j == i+1){
            System.out.println();
            print(i+1, 0, n);
        }
        else{
            System.out.print("* ");
            print(i, j+1, n);
        }
    }
}
