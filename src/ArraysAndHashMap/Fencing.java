package ArraysAndHashMap;
import java.util.*;

//https://www.codechef.com/problems/FENCE
public class Fencing {
    public static void main(String[] args) {
        //TC = O(t*k), SC = O(t*k)
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            List<List<Integer>> points = new ArrayList<>();
            HashSet<List<Integer>> hs = new HashSet<>();
            while(k-->0){
                int r = sc.nextInt();
                int c = sc.nextInt();
                List<Integer> point = List.of(r, c);
                points.add(point);
                hs.add(point);
            }
            System.out.println(minFence(n, m, points, hs));
        }
    }

    private static long minFence(int n, int m, List<List<Integer>> points, HashSet<List<Integer>> hs){
        /*
        1. Basically go to each cell and check its four adjacent cells - top, right, bottom, left
        2. If any of the 4 adjacent cell is outside the bounds then this adjacent side is touching the boundary
           and will be fenced so add it to total
        3. If any of the 4 adjacent cell is not present in the HashSet then it contains weed, so it will be fenced
           and added to total

         */
        long total = 0;
        for(List<Integer> point: points){
            int r = point.getFirst();
            int c = point.getLast();

            //cell above -> r-1, c
            if(r-1<1 || !hs.contains(List.of(r-1, c))){
                total += 1;
            }

            //cell right -> r, c+1
            if(c+1>m || !hs.contains(List.of(r, c+1))){
                total += 1;
            }

            //cell below -> r+1, c
            if(r+1>n || !hs.contains(List.of(r+1, c))){
                total += 1;
            }

            //cell left -> r, c-1
            if(c-1<1 || !hs.contains(List.of(r, c-1))) {
                total += 1;
            }
        }

        return total;
    }
}

/*
2
4 4 9
1 4
2 1
2 2
2 3
3 1
3 3
4 1
4 2
4 3
4 4 1
1 1
*/
