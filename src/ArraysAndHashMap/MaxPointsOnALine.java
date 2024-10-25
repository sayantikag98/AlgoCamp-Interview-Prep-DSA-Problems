package ArraysAndHashMap;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/max-points-on-a-line/description/
//https://chatgpt.com/share/66f9adaf-1f8c-8008-9b4b-5386e6945b74 -> ChatGPT Explanation
public class MaxPointsOnALine {
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{2,5}, {-4,6}, {8,-4}, {-3,-3}}));
        System.out.println(maxPointsMoreClean(new int[][]{{2,5}, {-4,6}, {8,-4}, {-3,-3}}));
    }

    private static int maxPointsMoreClean(int[][] points) {
        int maxPoints = 1;

        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> slopeCount = new HashMap<>();
            int duplicates = 0;
            int localMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];

                // Handle duplicates (when the two points are identical)
                if (deltaX == 0 && deltaY == 0) {
                    duplicates++;
                    continue;
                }

                // Calculate the GCD of deltaX and deltaY
                int gcd = gcd(deltaX, deltaY);

                // Reduce deltaX and deltaY by their GCD to get the simplified slope
                deltaX /= gcd;
                deltaY /= gcd;

                // To ensure uniqueness, ensure that deltaX is always positive
                if (deltaX < 0) {
                    deltaX = -deltaX;
                    deltaY = -deltaY;
                }

                // Construct the slope string as "deltaY/deltaX"
                String slope = deltaY + "/" + deltaX;

                // Update the count of points that share this slope with point i
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeCount.get(slope));
            }

            // Add the duplicate points to the maximum count for the current base point
            maxPoints = Math.max(maxPoints, localMax + duplicates + 1);
        }

        return maxPoints;
    }

    // Helper function to calculate GCD
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    private static int maxPoints(int[][] points) {
        //TC = O(n^2), SC = O(n^2)
        int maxPoints = 1, n = points.length;
        HashMap<List<Double>, HashSet<Integer>> hm = new HashMap<>();
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                List<Double> key;
                if(x2 == x1){
                    key = List.of(Double.MAX_VALUE, (double)x1);
                }
                else{
                    double slope = ((double)(y2 - y1))/(x2 - x1);
                    double intercept = y2 - slope*x2;
                    key = List.of(slope, intercept);
                }
                HashSet<Integer> value;
                if(hm.containsKey(key)){
                    value = hm.get(key);
                }
                else{
                    value = new HashSet<>();
                    hm.put(key, value);
                }
                value.add(i);
                value.add(j);
                maxPoints = Math.max(maxPoints, value.size());
            }
        }
        return maxPoints;
    }
}
