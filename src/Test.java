import java.util.*;
public class Test {

    public static void main(String[] args) {
        HashSet<List<Integer>> hs = new HashSet<>();
        hs.add(List.of(1, 2));
        if(hs.contains(List.of(1,2))){
            System.out.println("hello");
        }
    }
}
