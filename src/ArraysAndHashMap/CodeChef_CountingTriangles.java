package ArraysAndHashMap;
import java.util.Scanner;
import java.util.HashMap;

public class CodeChef_CountingTriangles {
    //https://www.codechef.com/problems/CORE4

    //Note: Duplicate coordinates will not come in the input

    /*
    Sample Input:
    10
    0 0
    0 1
    1 0
    8 9
    3 4
    4 3
    4 4
    5 6
    9 6
    5 9
     */

    //TC = O(n) + O(n) = O(n)
    //SC = O(2*n) + O(no of unique x coordinates) + O(no of unique y coordinates) = O(n)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), i = 0;
        int[] xCoor = new int[n];
        int[] yCoor = new int[n];

        HashMap<Integer, Integer> hmx = new HashMap<>();
        HashMap<Integer, Integer> hmy = new HashMap<>();
        while(i<n){
            xCoor[i] = sc.nextInt();
            yCoor[i] = sc.nextInt();
            hmx.put(xCoor[i], hmx.getOrDefault(xCoor[i], 0) + 1);
            hmy.put(yCoor[i], hmy.getOrDefault(yCoor[i], 0) + 1);
            i++;
        }
        System.out.println(countTriangles(n, xCoor, yCoor, hmx, hmy));
    }

    private static int countTriangles(int n, int[] xCoor, int[] yCoor, HashMap<Integer, Integer> hmx, HashMap<Integer, Integer> hmy){
        int count = 0, mod = 10000;
        for(int i = 0; i<n; i++){
            int xCoorCount = hmx.get(xCoor[i]) - 1;
            int yCoorCount = hmy.get(yCoor[i]) - 1;
            int mul = ((xCoorCount % mod) * (yCoorCount % mod)) % mod;
            count += mul;
        }
        return count%mod;
    }
}
