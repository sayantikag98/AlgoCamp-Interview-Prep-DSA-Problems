import java.util.*;
public class Test {

    public static void main(String[] args) {
        HashSet<List<Integer>> hs = new HashSet<>();
        hs.add(List.of(1, 2));
        if(hs.contains(List.of(1,2))){
            System.out.println("hello");
        }

        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.addFirst(0);
        System.out.println(l);

        StringBuilder sb = new StringBuilder();
        sb.append(10);
        System.out.println(Integer.parseInt("-10"));

    }
}
