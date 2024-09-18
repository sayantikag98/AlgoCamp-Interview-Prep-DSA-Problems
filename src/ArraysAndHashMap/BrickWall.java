package ArraysAndHashMap;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/brick-wall/
public class BrickWall {

    public static void main(String[] args) {
        int[][] arr = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        // Converting int[][] to List<List<Integer>> using streams
        List<List<Integer>> list =
                Arrays.stream(arr).map(ints -> IntStream.of(ints)
                                .boxed()
                                .collect(Collectors.toList()))
                                .toList();

        /*
        Sure! Let's break down this line of code:

        ```java
        List<List<Integer>> list =
            Arrays.stream(arr).map(ints -> IntStream.of(ints)
                                .boxed()
                                .collect(Collectors.toList()))
                                .toList();
        ```

        Here, we're converting a 2D `int[][]` array (called `arr`) to a `List<List<Integer>>` using Java Streams. We'll break down each part:

        ### 1. `Arrays.stream(arr)`
        - **Explanation:**
          - `arr` is a 2D array (`int[][]`).
          - `Arrays.stream(arr)` converts the array `arr` into a stream of its rows. Since `arr` is a 2D array, each element in this stream is a 1D array (`int[]`).

        ### 2. `.map(ints -> IntStream.of(ints)`
        - **Explanation:**
          - The `.map()` function applies a transformation to each element in the stream. In this case, each element `ints` is a 1D `int[]` array (i.e., a row from the 2D array).
          - `IntStream.of(ints)` creates a stream of primitive integers from this `int[]` array.

        ### 3. `.boxed()`
        - **Explanation:**
          - `IntStream.of(ints)` is a stream of primitive `int` values. The `.boxed()` method converts each `int` in the stream into its corresponding wrapper class `Integer`. This transforms an `IntStream` into a `Stream<Integer>`.

        ### 4. `.collect(Collectors.toList())`
        - **Explanation:**
          - After boxing the `int` values to `Integer`, we want to collect them into a list.
          - `Collectors.toList()` is a collector that accumulates the stream's elements (in this case, the `Integer` values) into a `List<Integer>`.
          - So, for each `int[]` array, this part of the code produces a `List<Integer>` representing the row.

        ### 5. `.toList()`
        - **Explanation:**
          - After transforming each `int[]` into a `List<Integer>`, we use `.toList()` to collect the results into a `List<List<Integer>>`. This is essentially accumulating the `List<Integer>` results (each representing a row) into a larger list.

        ### Entire Process (Summary):
        - **Step-by-Step:**
          1. The 2D array (`arr`) is transformed into a stream of 1D arrays (`int[]`).
          2. Each `int[]` is processed:
             - Converted into a stream of `int` values.
             - Each `int` is boxed into an `Integer`.
             - The boxed `Integer` values are collected into a `List<Integer>`.
          3. Finally, all the individual `List<Integer>`s are collected into a `List<List<Integer>>`.

        ### Final Example:

        Let's assume `arr` looks like this:

        ```java
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        ```

        The line of code would convert this `int[][]` array to a `List<List<Integer>>` as:

        ```
        [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        ```

        Each row of the 2D array is transformed into a `List<Integer>`, and the entire structure is represented as a `List<List<Integer>>`.
         */
        System.out.println(leastBricks(list));
    }

    private static int leastBricks(List<List<Integer>> wall) {
        //n -> wall.size(), m = max wall[i].size()
        //TC = O(n*m), SC = O(n)
        HashMap<Long, Integer> freq = new HashMap<>();
        int ans = 0;
        for(List<Integer> l: wall) {
            long sum = 0;
            for (int i = 0; i < l.size() - 1; i++) {
                sum += l.get(i);
                freq.put(sum, freq.getOrDefault(sum, 0) + 1);
                ans = Math.max(ans, freq.get(sum));
            }
        }
        return wall.size()-ans;
    }
}
